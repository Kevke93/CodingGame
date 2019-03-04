waitingQueue,memoDict = [],{}
cash, nextGroup = 0, 0

l, c, n = [int(i) for i in input().split()]
for i in range(n):
    waitingQueue.append(int(input()))

for i in range(c):

    if nextGroup in memoDict.keys():
        cash += memoDict[nextGroup]['rideCash']
        nextGroup = memoDict[nextGroup]['nextGroup']
    else:
        freeSeats = l
        firstGroup = nextGroup
        rideCash = 0

        while freeSeats != 0:
            if waitingQueue[nextGroup] <= freeSeats:
                rideCash += waitingQueue[nextGroup]
                freeSeats -= waitingQueue[nextGroup]
                nextGroup = nextGroup + 1 if nextGroup+1 < n else 0
                if firstGroup == nextGroup:
                    break
            else:
                break
        memoDict[firstGroup] = {'nextGroup':nextGroup,'rideCash': rideCash}
        cash += rideCash
print(cash)
