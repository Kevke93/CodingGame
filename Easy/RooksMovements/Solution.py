import sys
import math

rowchars = ["a", "b", "c", "d", "e", "f", "g", "h"]
result=[]

def checkDownUP(start, end, step):

    for i in range(start, end, step):
        if field[i][rCol] == 1:
            result.append("R" + rowchars[rCol] + str(rRow) + "x" + str(rowchars[rCol]) + str(i + 1))
            return
        if field[i][rCol] == 0:
            return
        result.append("R" + rowchars[rCol] + str(rRow) + "-" + str(rowchars[rCol]) + str(i+1))
    return

def checkLeftRight (start, end, step):

    for i in range(start, end, step):
        if field[rRow-1][i] == 1:
            result.append("R" + rowchars[rCol] + str(rRow) + "x" + str(rowchars[i]) + str(rRow))
            return
        if field[rRow-1][i] == 0:
            return
        result.append("R" + rowchars[rCol] + str(rRow) + "-" + str(rowchars[i]) + str(rRow))
    return

rCol, rRow = [c for c in input()]
rCol = rowchars.index(rCol)
rRow=int(rRow)
nb_pieces = int(input())

field = [[-1 for j in range(0, 8)] for i in range(8, 0, -1)]

for i in range(nb_pieces):
    one_piece = input().split()
    pos = [c for c in one_piece[1]]

    field[int(pos[1]) - 1][rowchars.index(pos[0])] = int(one_piece[0])


checkDownUP(int(rRow)-2, -1, -1)
checkDownUP(int(rRow),8,1)
checkLeftRight (rCol-1,-1,-1)
checkLeftRight (rCol+1,8,+1)

resultSorted = sorted(result)

for x in resultSorted:
    print(x)