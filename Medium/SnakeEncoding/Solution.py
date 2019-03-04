size = int(input())
repeats = int(input())
grid = [[x for x in input()] for _ in range(size)]

#Calculate the Position of the Charackter at Position of the Charackter at x,y after 1 Move
def nextPositon(x, y):
    if x % 2 == 0:
        if x == size - 1 and y == 0:
            return 0, size - 1
        if y == 0:
            return x + 1, y
        return x, y - 1
    if x == size - 1 and y == size - 1:
        return 0, size - 1
    if y == size - 1:
        return x + 1, y
    return x, y + 1

#Go through the Sheme based on nextPosition. Therefore Save the Charakter which will beo overwritten
#as NextChar
for _ in range(repeats):
    nextX, nextY = 0, size - 1
    nextChar = grid[nextY][nextX]
    for _ in range(size**2):
        nextX, nextY = nextPositon(nextX, nextY)
        grid[nextY][nextX], nextChar = nextChar, grid[nextY][nextX]

for row in grid:
    print(*row,sep="")
