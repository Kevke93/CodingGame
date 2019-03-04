import sys
import math


n = int(input())
housesX=[]
housesY=[]
for _ in range(n):
    x, y = [int(j) for j in input().split()]
    housesX.append(x)
    housesY.append(y)


housesY=sorted(housesY)

if n%2==1 :
    ypos=housesY[(n+1)//2-1]
else:
    ypos = int(0.5*(housesY[(n//2)-1]+ housesY[(n//2)]))
    
Cable=sum(abs(y-ypos) for y in housesY)

print(Cable + max(housesX)-min(housesX))
