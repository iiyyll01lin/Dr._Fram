from imutils.video import VideoStream
import numpy as np
import argparse
import imutils
import time
import cv2
import os
import json

# construct the argument parse
ap = argparse.ArgumentParser()
ap.add_argument("-y", "--yolo", required=True,
    help="base path to YOLO directory")
ap.add_argument("-c", "--confidence", type=float, default=0.5,
    help="minimum probability to filter weak detections")
ap.add_argument("-t", "--threshold", type=float, default=0.3,
    help="threshold when applying non-maxima suppression")
args = vars(ap.parse_args())

# load label
labelsPath = os.path.sep.join([args["yolo"], "mango.names"])
LABELS = open(labelsPath).read().strip().split("\n")
COLORS = np.random.randint(0, 255, size=(len(LABELS), 3),dtype="uint8")

# load paths to the YOLO weights and configuration
weightsPath = os.path.sep.join([args["yolo"], "yolov4-tiny-mango_0317_3000.weights"])
configPath = os.path.sep.join([args["yolo"], "yolov4-tiny-mango_0317.cfg"])

# load our YOLO object detector and determine only the *output* layer names
print("[Dr. Farm] loading YOLO from disk...")
net = cv2.dnn.readNetFromDarknet(configPath, weightsPath)
ln = net.getLayerNames()
ln = [ln[i[0] - 1] for i in net.getUnconnectedOutLayers()]

# warm camera
cap = VideoStream(src=0, framerate=30, resolution=1280*720).start()
time.sleep(2.0)
pic=[0,0] # for taking picture [pic_get, pic_type]
position= "unknow" # zone
picTime = [time.time(),0] # [last taking picture time, the number of picture]
with open("//home//pi//Farm_info//public//farmData.json", 'w') as obj:
    obj.write("[")

while True:
    # rezise frame
    frame = cap.read()
    frame = cv2.resize(frame, (700, 600))
    (H, W) = frame.shape[:2]

    # pass the blob through the network and forward network
    blob = cv2.dnn.blobFromImage(frame, 1 / 255.0, (416, 416), swapRB=True, crop=False)
    net.setInput(blob)
    layerOutputs = net.forward(ln)

    # initialize our lists of detected bounding boxes, confidences, and class IDs, respectively
    boxes = []
    confidences = []
    classIDs = []


    for output in layerOutputs:
        for detection in output:
            # extract the class ID and confidence (i.e., probability) of the current object detection
            scores = detection[5:]
            classID = np.argmax(scores)
            confidence = scores[classID]

            # filter out weak predictions by ensuring the detected probability is greater than the minimum probability
            """
            if confidence > args["confidence"]:
                if pic[0] == 0:
                    pic[:]=[1,0] if classID==0 else [1,1] # check mango type

            """

                box = detection[0:4] * np.array([W, H, W, H])
                (centerX, centerY, width, height) = box.astype("int")
                x = int(centerX - (width / 2))
                y = int(centerY - (height / 2))

                # update our list of bounding box coordinates, confidences, and class IDs
                boxes.append([x, y, int(width), int(height)])
                confidences.append(float(confidence))
                classIDs.append(classID)
    # apply non-maxima suppression to suppress weak, overlapping bounding boxes
    idxs = cv2.dnn.NMSBoxes(boxes, confidences, args["confidence"], args["threshold"])

    # ensure at least one detection exists
    if len(idxs) > 0:
        # loop over the indexes we are keeping
        for i in idxs.flatten():
            # extract the bounding box coordinates
            (x, y) = (boxes[i][0], boxes[i][1])
            (w, h) = (boxes[i][2], boxes[i][3])

            # draw a bounding box rectangle and label on the frame
            color = [int(c) for c in COLORS[classIDs[i]]]
            cv2.rectangle(frame, (x, y), (x + w, y + h), color, 2)
            text = "{}: {:.4f}".format(LABELS[classIDs[i]],
                confidences[i])
            cv2.putText(frame, text, (x, y - 5),
                cv2.FONT_HERSHEY_SIMPLEX, 0.5, color, 2)

    if pic[0] == 1:
        cv2.imwrite('//home//pi//Farm_info//public//images//'+ str(picTime[1]) +'.jpg',frame)
        print("[Dr. Farm] take a mango picture!")
        picTime[0] = time.time()
        if picTime[1]%4 == 0:
            zone="A"
        elif picTime[1]%4 == 1:
            zone="B"
        elif picTime[1]%4 == 2:
            zone="C"
        else:
            zone="D"

        jasonData = {"zone":zone,"picNumber":picTime[1],"type":pic[1],"time":time.asctime(time.localtime(picTime[0]))}
        picTime[1] += 1
        with open("//home//pi//Farm_info//public//farmData.json", 'a') as obj:
            json.dump(jasonData, obj)
            obj.write(",")

    if picTime[1] != 0:
        pic[0] = 0 if time.time() - picTime[0] > 10 else 2

    cv2.imshow("Output", frame)
    if cv2.waitKey(1) & 0xFF == ord('q'):
        print("okok json")
        with open("//home//pi//Farm_info//public//farmData.json", 'a') as obj:
            obj.write(" {} ] ")

        break

print("[Dr. Farm] cleanup up...")
cap.release()
cv2.destroyAllWindows()