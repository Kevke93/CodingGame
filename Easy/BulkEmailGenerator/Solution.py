
text = "\n".join(input()for _ in range(int(input())))
counter = 0
result=text
for i, x in enumerate(text):
    if x == "(":
        for j, y in enumerate(text[i:], start=i + 1):
            if y == ")":
                subText = text[i + 1:j - 1].split("|")
                result = result.replace(text[i:j], subText[counter% len(subText)], 1)
                counter+=1
                break

print(result)