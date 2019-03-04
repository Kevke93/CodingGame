width, height = [int(i) for i in input().split()]
field = [[x for x in input()] for _ in range(height )]

for i in range(width):
    counter = 0
    for j in range(height):
        if field[j][i] == '#':
            counter += 1
    for j in range(height - 1, -1, -1):
        if counter > 0:
            field[j][i] = '#'
            counter -= 1
        else:
            field[j][i] = '.'

for row in field:
    print(*row, sep="")
