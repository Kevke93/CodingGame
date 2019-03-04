def nearPalindron(word, noChanges=True):
    if len(word) <= 1:
        return True
    for i in range(len(word) // 2):
        if word[i] != word[-i - 1]:
            if noChanges:
                test1 = nearPalindron(word[i + 1: len(word) - i - 1], False)
                test2 = nearPalindron(word[i: len(word) - i - 1], False)
                test3 = nearPalindron(word[i + 1: len(word) - i], False)
                return (test1 or test2 or test3)
            else:
                return False
    return True

output = ""
for _ in range(int(input())):
    output += str(int(nearPalindron(input())))
print(output)
