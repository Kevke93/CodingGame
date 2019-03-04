def formular(wheigt,level):
    return ((level-1) * 6.5 / 100) * 10 * wheigt
    

rowLimit = int(input())
n = int(input())
wheigts = sorted([int(i) for i in input().split()],reverse=True)

currentLw, blocksIncurrentLevel, work = 0, 0, 0

for w in wheigts:

    
    
    currentLw+=1 if blocksIncurrentLevel//rowLimit ==0 else 0
    blocksIncurrentLevel+=1
    work+=formular(w,currentLw)
    
print(format(work,".3f"))
