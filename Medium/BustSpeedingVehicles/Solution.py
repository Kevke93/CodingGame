def speedInKmh(timeSec, distanceKm):
    return distanceKm / (timeSec / 3600)


limit = int(input())
n = int(input())
allSpeed = []
for i in range(n):
    allSpeed.append(input().split())

noLimitBreak = True
for i in range(1, n):
    if allSpeed[i][0] == allSpeed[i - 1][0]:
        plate, distanceStart, timeStart = allSpeed[i - 1]
        _, distanceEnd, timeEnd = allSpeed[i]
        if speedInKmh(int(timeEnd) - int(timeStart), int(distanceEnd) - int(distanceStart)) > limit:
            print(plate, distanceEnd, sep=" ")
            noLimitBreak = False
if noLimitBreak:
    print("OK")
