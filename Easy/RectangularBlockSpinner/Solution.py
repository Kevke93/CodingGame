import sys
import math
from itertools import combinations_with_replacement


def createDiamond(chaList, size):
    diamond = [[" " for _ in range(2 * size - 1)] for _ in range(2 * size - 1)]
    iterList = iter(chaList)
    start = (2 * size - 1) // 2
    end = (2 * size - 1) // 2
    halfreached = False
    for i in range(2 * size - 2):
        diamond[i][start] = next(iterList)
        tempStart = start + 2
        while tempStart <= end:
            diamond[i][tempStart] = next(iterList)
            tempStart += 2
        if halfreached:
            start += 1
            end += -1
        else:
            start -= 1
            end += 1
            if start == 0:
                halfreached = True
    diamond[2 * size - 2][(2 * size - 1) // 2] = next(iterList)
    for line in diamond:
        print("".join(line))


size = int(input())
angle = int(input())
lines = []
for i in range(size):
    lines.append(input().split())

angle = (angle // 90) % 4
# save the inputs in the correct output order for
output = []
if angle == 0:
    for i in range(size - 1, -1, -1):
        counterX = i
        counterY = 0
        while counterX != size:
            output.append(lines[counterY][counterX])
            counterX += 1
            counterY += 1
    for i in range(1, size, 1):
        counterX = 0
        counterY = i
        while counterY != size:
            output.append(lines[counterY][counterX])
            counterX += 1
            counterY += 1
elif angle == 1:
    for i in range(size - 1, -1, -1):
        counterX = size - 1
        counterY = i
        while counterY != size:
            output.append(lines[counterY][counterX])
            counterX -= 1
            counterY += 1

    for i in range(size - 2, -1, -1):
        counterX = i
        counterY = 0
        while counterX >= 0:
            output.append(lines[counterY][counterX])
            counterX -= 1
            counterY += 1
elif angle == 3:
    for i in range(0, size):
        counterY = i
        counterX = 0
        while counterY >= 0:
            output.append(lines[counterY][counterX])
            counterX += 1
            counterY -= 1
    for j in range(1,size,1):
        counterY=size-1
        counterX=j
        while counterX !=size:
            output.append(lines[counterY][counterX])
            counterX += 1
            counterY -= 1

createDiamond(output, size)
