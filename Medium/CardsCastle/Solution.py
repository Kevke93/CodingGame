DIRECTION = ["/", "\\"]
HEIGHT = int(input())
grid = [[x for x in input()] for _ in range(HEIGHT)]
WIDHT = len(grid[0])
stable = True
for i in range(HEIGHT):
    for j in range(WIDHT):
        if grid[i][j] != ".":
            card = grid[i][j]
            oppositeCard = DIRECTION[abs(DIRECTION.index(card) - 1)]
            direction = -1 if DIRECTION.index(card) == 0 else 1

            if WIDHT - 1 < j - direction or j - direction < 0 or grid[i][j - direction] != oppositeCard:
                stable = False
                break
            y, x = i, j
            while y < HEIGHT:
                if x < 0 or x >= WIDHT or grid[y][x] != card:
                    stable = False
                    break
                y += 1
                x += direction

print('STABLE' if stable else 'UNSTABLE')