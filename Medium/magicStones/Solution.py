import sys
import math

n = int(input())
stones = [int(i) for i in input().split()]
changes = True

while changes:
    changes = False
    for s in stones:
        if stones.count(s)>=2:
            stones.pop(stones.index(s))
            stones[stones.index(s)] +=1
            changes = True

print(len(stones))