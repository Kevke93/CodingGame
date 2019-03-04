import sys
import math

# Auto-generated code below aims at helping you parse
# the standard input according to the problem statement.

n = int(input())
dom=[]
for i in range(n):
    a, b = [int(j) for j in input().split()]
    dom.append([a,b])
    
dom = sorted(dom)
test="true"
for i in range(0,len(dom)-1,1):
    if(dom[i][1]!=dom[i+1][0]):
        test="false"
        break;

print(test)