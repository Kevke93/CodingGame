DIRECTION_CLOCK = [(0, -1), (1, 0), (0, 1), (-1, 0), (0, -1)]
W_B = [".", "#"]
w, h = [int(i) for i in input().split()]
x, y = [int(i) for i in input().split()]
direction = DIRECTION_CLOCK["NESW".index(input())]
turns = int(input())
grid = [[x for x in input()] for i in range(h)]
for i in range(turns):

    if grid[y][x] == W_B[0]:
        #90 degrees Left
        direction = DIRECTION_CLOCK[len(DIRECTION_CLOCK) - DIRECTION_CLOCK[::-1].index(direction)-2]
    else:
        #90 degrees Right
        direction = DIRECTION_CLOCK[DIRECTION_CLOCK.index(direction) + 1]
    grid[y][x] = W_B[0] if grid[y][x] == W_B[1] else W_B[1]
    y += direction[1]
    x += direction[0]

for line in grid:
    print(*line, sep="")