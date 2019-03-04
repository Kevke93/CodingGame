NON_VISIBLE = '#'
VISIBLE = '.'
widht = int(input())
height = int(input())
field = [[x for x in input()] for _ in range(height)]
iDTranslate = {}


def initalizeTower():
    tower, counter = {}, 0
    counter = 0
    for i in range(height):
        for j in range(widht):
            if field[i][j] != NON_VISIBLE and field[i][j] != VISIBLE:
                iDTranslate[counter] = field[i][j]
                tower[counter] = [(i, j)]
                counter += 1
    return tower


def calculateNextMoves(tower):
    changes = False
    for key, values in tower.items():
        tower[key] = []
        for y, x in values:
            for ynew, xnew in [(y + 1, x), (y - 1, x), (y, x - 1), (y, x + 1)]:
                if height > ynew >= 0 and widht > xnew >= 0 and field[ynew][xnew] == VISIBLE:
                    changes = True
                    tower[key].append((ynew, xnew))
    return changes, tower


changes, tower = True, initalizeTower()

while changes:
    changes, tower = calculateNextMoves(tower)

    for key, values in tower.items():
        for y, x in values:
            if field[y][x] == VISIBLE:
                field[y][x] = key
            elif field[y][x] != key:
                field[y][x] = "+"

# replace the all the Tower translated it to the original ones
for i in range(height):
    for j in range(widht):
        if field[i][j] in iDTranslate:
            field[i][j] = iDTranslate[field[i][j]]

for row in field:
    print(*row, sep="")
