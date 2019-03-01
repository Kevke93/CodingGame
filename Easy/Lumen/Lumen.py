n = int(input())
light = int(input())
field = [[i for i in input().split()] for _ in range(n)]
lightCounter = 0
for i in range(n):
    for j in range(n):
        if field[i][j] == "C":
            lightCounter += 1
            for k in range(max(i-light+1, 0), min(i+light, n)):
                for m in range(max(j-light+1, 0), min(j+light, n)):
                    if field[k][m] == "X":
                        field[k][m] = "1"
                        lightCounter += 1
print(lightCounter)
