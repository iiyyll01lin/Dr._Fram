# README

# Dr._Farm

# Intro

Dr Farm is an Auto Defect Detection Project with Autonomous Driving, Object Detection & Discrimination, and a Web App.

Dr Farm is a project consisting of 3 parts: autonomous driving, object detection and web application.

# Pi_Donkeycar & Pi_Camera
The autonomous driving part is inherited from Donkeycar (https://github.com/autorope/donkeycar), which is trained to specialize in fram tracks; the object detection part is trained using YOLOv4-tiny model, and the web app part uses Node.js to connect to two Raspberry Pis on the car, this is why we have two directories, Pi_Donkeycar and Pi_Camera, to represent the separate deployment.

# Ubuntu_train
The Ubuntu_train directory contains how to train the self-diving models by Keras. The model is quantized by TensorFlow Lite and pruned in some scale to deploy on Raspberry Pi successfully. I left some models in Ubuntu_train/mycar/ I trained for your reference. BTW, the mypilot_0308_base.h5 model is the most stable for my track, FYI.

# Web_App
The Web_App directory contains all the Servlets, Node.js, and views to support the connection between two Raspberry Pis and the Website.
