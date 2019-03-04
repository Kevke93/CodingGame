import sys
import math

# Auto-generated code below aims at helping you parse
# the standard input according to the problem statement.

robbers = int(input())
v = int(input())
com = []
for i in range(v):
    c, n = [int(j) for j in input().split()]
    com.append(10**n * 5**(c-n))

time=0
while len(com)>0:
    minVal = min(com)
    
    for i in range(min(robbers,len(com))):
        com[i]  -=minVal
       
    while 0 in com:
        com.remove(0)
    time    +=minVal
print(time)