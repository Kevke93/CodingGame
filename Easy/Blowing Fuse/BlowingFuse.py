n, _, maxPower = [int(i) for i in input().split()]
field = [[0]*2 for i in range(n)]
currentPower, maxPowerUsed = 0, 0

for i, k in enumerate(input().split()):
    field[i][0] = int(k)

for i in input().split():
    cl = int(i)
    
    field[cl-1][1] = 1 - field[cl-1][1]
    currentPower += field[cl-1][0] if field[cl-1][1] == 1 else -1*field[cl-1][0]
    maxPowerUsed = max(currentPower, maxPowerUsed)
    
if maxPowerUsed > maxPower:
    print("Fuse was blown.")
else:
    print("Fuse was not blown.\nMaximal consumed current was " + str(maxPowerUsed) + " A.")
