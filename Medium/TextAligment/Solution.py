alignment = input()
n = int(input())
lineList = [input() for _ in range(n)]
lineSize = len(max(lineList, key=lambda x: len(x)))

if alignment == 'LEFT':
    print(line)for line in lineList:
       
elif alignment == 'RIGHT':
    for line in lineList:
        leadingSpace = " " * (lineSize - len(line))
        print(leadingSpace + line)
elif alignment == 'CENTER':
    for line in lineList:
        leadingSpace = ' ' * ((lineSize - len(line)) // 2)
        print(leadingSpace + line)
else:
    for line in lineList:
        whitespaces = (lineSize - len(line)) / (len(line.split()) - 1)
        aligment = []
        
        for i, word in enumerate(line.split()):
            if i == 0:
                aligment.append(word)
            else:
                aligment.append(" " * (int(i * whitespaces - (i - 1) * whitespaces) + 1) + word)
        print("".join(aligment))
