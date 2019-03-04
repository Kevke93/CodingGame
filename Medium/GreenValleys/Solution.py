h, n = int(input()), int(input())
field = [[int(j) for j in input().split()] for _ in range(n)]
visited = set()


def floodfill(y, x):
    nearbyField = [(y, x)]
    visited.add((y, x))
    count, lowestPoint, changes = 1, field[y][x], True
    while changes:
        changes = False
        for pos in nearbyField:
            y, x = pos
            nearbyField.remove(pos)
            for ynew, xnew in [(y + 1, x), (y - 1, x), (y, x - 1), (y, x + 1)]:
                if n > ynew >= 0 and n > xnew >= 0:
                    if field[ynew][xnew] <= h and (ynew, xnew) not in visited:
                        nearbyField.append((ynew, xnew))
                        visited.add((ynew, xnew))
                        changes = True
                        count += 1
                        lowestPoint = min(field[ynew][xnew], lowestPoint)
    return count, lowestPoint


vallies = [(0, 0)]
for y in range(n):
    for x in range(n):
        if field[y][x] <= h and not (y, x) in visited:
            vallies.append(floodfill(y, x))
print(max(vallies, key=lambda x: (x[0], -1 * x[1]))[1])