NOWATER = '#'
lenght = int(input())
height = int(input())
field = [[x for x in input()] for _ in range(height)]


def getAllNearbers(coord):
    x, y = coord
    return [(x, y - 1), (x, y + 1), (x - 1, y), (x + 1, y)]


def floodfillMain(x, y):
    visited, stack = set(), set()
    visited.add((x, y))
    stack.add((x, y))

    while len(stack) > 0:
        moves = getAllNearbers(stack.pop())

        for move in moves:
            if move not in visited:
                if lenght > move[0] >= 0 and height > move[1] >= 0 and field[move[1]][move[0]] != NOWATER:
                    visited.add(move)
                    stack.add(move)

    return len(visited)


for i in range(int(input())):
    x, y = [int(j) for j in input().split()]

    if field[y][x] == NOWATER:
        print(0)
    else:
        print(floodfillMain(x, y))
