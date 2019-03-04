import sys
import math

# Auto-generated code below aims at helping you parse
# the standard input according to the problem statement.

def calcDist(longA, longB, latA, latB):
    x = (longB-longA)*math.cos((latA+latB )/2)
    y = latB-latA
    return math.pow(x*x + y*y ,0.5) * 6371

lon = float(input().replace(",","."))
lat = float(input().replace(",","."))

n = int(input())

defib = [input().split(";") for i in range(n) ]

minimum=100000.
minIndex=-1
for i in range (n):
    longB=float(defib[i][-2].replace(",","."))
    latB=float(defib[i][-1].replace(",","."))
    
    tempMin = calcDist(lon, longB, lat, latB )
    
    if(tempMin<minimum):
        minimum=tempMin
        minIndex=i


print(defib[minIndex][1])