#!/usr/bin/python
 
import threading
import time
import os

cmd = "curl http://localhost:8072/rest/hello/client"
 
def worker1(message):
  while 1:
    os.system(cmd + " && echo '\n' ")

def worker2(cmd):
   while 1:
     os.system(cmd + " && echo '\n' ")
 
t1 = threading.Thread(target=worker1,args=(cmd,))
t1.start()

t2 = threading.Thread(target=worker2,args=(cmd,))
t2.start()

#while 1:
#  a = 1 
#print("")
#  time.sleep(5)
 
#print("Thread morreu")
#print("Finalizando programa")
