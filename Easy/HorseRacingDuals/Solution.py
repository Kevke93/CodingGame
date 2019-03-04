import sys
import math

# Auto-generated code below aims at helping you parse
# the standard input according to the problem statement.

n = int(input())

h = [int(input()) for i in range(n) ]
h.sort(reverse=True)

min = 10000
for i in range(n-1):
    if(abs(h[i]-h[i+1]) < min):
        min=abs(h[i]-h[i+1])

print(min)