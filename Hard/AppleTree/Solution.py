class apple():

    def __init__(self, x, y, z, r):
        self.x = x
        self.y = y
        self.z = z
        self.r = r

n, index = map(int, input().split())
apple_tree, falen_apples = [], []
for i in range(n):
    x, y, z, r = map(int, input().split())
    new_apple = apple(x, y, z, r)
    apple_tree.append(new_apple)
falen_apples.append(apple_tree[index])
apple_tree.sort(key=lambda s: s.z, reverse=True)

for i in range(apple_tree.index(falen_apples[0])+1, n):
    current_apple = apple_tree[i]
    for falen_apple in falen_apples:
        distance = current_apple.r + falen_apple.r
        if current_apple.z <= falen_apple.z:
            if (abs(current_apple.x - falen_apple.x) < distance
                and abs(current_apple.y - falen_apple.y) < distance):
                    falen_apples.append(current_apple)
                    break

print(n - len(falen_apples))
