import sys
import math

# Auto-generated code below aims at helping you parse
# the standard input according to the problem statement.

n = int(input())
field = []
for i in input().split():
    field.append(int(i))

counter = 0
for i, numb in enumerate(field):
    if numb == 0:
        for j in range(len(field) - 1, i, -1):
            if field[j] == 1:
                field[i], field[j] = 1, 0
                counter += 1
                break

print(counter)