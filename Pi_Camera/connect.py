import socket
port=8081
host="localhost"
s=socket.socket(socket.AF_INET,socket.SOCK_DGRAM)
s.sendto("hello word",(host,port))