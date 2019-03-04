width, height = [int(i) for i in input().split()]
grid = [[int(x) for x in input()] for _ in range(height)]
newGrid = [[0 for _ in range(width)] for _ in range(height)]
OFFSET = ((1, 0), (1, 1), (0, 1), (-1, 1), (-1, 0), (-1, -1), (0, -1), (1, -1))


def count_livingNN(y, x):
    counter = 0

    for offY, offX in OFFSET:
        if height > y + offY >= 0 and width > x + offX >= 0 :
            counter += grid[y + offY][x + offX]
    return counter


for y in range(height):
    for x in range(width):
        neighb = count_livingNN(y, x)

        if grid[y][x] == 1 and (neighb == 2 or neighb == 3):
            newGrid[y][x] = 1
        elif grid[y][x] == 0 and neighb == 3:
            newGrid[y][x] = 1

for row in newGrid:
    print(*row, sep="")
