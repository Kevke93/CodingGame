w, h = [int(i) for i in input().split()]

field = [[int(j) for j in input().split()]for i in range(h)]
max_cost = [[0 for _ in range(w)] for _ in range(h)]

max_cost[0][0] = field[0][0]

for i in range(1, w):
    max_cost[0][i] = max_cost[0][i-1] + field[0][i]
for i in range(1, h):
    max_cost[i][0] = max_cost[i-1][0] + field[i][0]

for i in range(1, h):
    for j in range(1, w):
        max_cost[i][j] = max(max_cost[i-1][j], max_cost[i][j-1]) + field[i][j]

print(max_cost[h-1][w-1])