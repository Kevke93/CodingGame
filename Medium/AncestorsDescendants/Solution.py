from collections import deque

count = int(input())
listQueue = deque()
for _ in range(count):
    line = input()
    if line.count(".") + 1 > len(listQueue):
        listQueue.append(line.replace(".", ""))
    else:
        print(*listQueue, sep=" > ")
        for k in range(len(listQueue) - line.count(".")):
            listQueue.pop()
        listQueue.append(line.replace(".", ""))

print(*listQueue, sep=" > ")