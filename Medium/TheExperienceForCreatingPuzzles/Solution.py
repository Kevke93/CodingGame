def xpCurrentLevel(level):
    return int(level ** 1.5 * 10)


level = int(input())
xpThisLevel = xpCurrentLevel(level) - int(input())
gainedXP = int(input()) * 300 + xpThisLevel

while gainedXP >= xpCurrentLevel(level):
    gainedXP -= xpCurrentLevel(level)
    level += 1

print(level,xpCurrentLevel(level) - gainedXP, sep='\n')