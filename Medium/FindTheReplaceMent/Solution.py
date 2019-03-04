x, y = input(), input()
output, memoDict = [], {}
cannot = False
for i in range(len(x)):
    if x[i] in memoDict.keys():
        if memoDict[x[i]] != y[i]:
            cannot = True
            break
    else:
        memoDict[x[i]] = y[i]
        if x[i] != y[i]:
            output.append((x[i], y[i]))

if cannot:
    print("CAN'T")
elif len(output) == 0:
    print('NONE')
else:
    for key, value in output:
        print(key, value, sep='->')
