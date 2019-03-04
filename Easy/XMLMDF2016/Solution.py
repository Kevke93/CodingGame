sequence = input()
dict = {}

for i, char in enumerate(sequence):
    """ If - is  a closing sign scipe it an the next letter"""
    if char == "-":
        i += 1
        continue

    if i != 0:
        closing = sequence.count("-", 0, i - 1)
        starting = i- 3 * closing
        currentWheigt = 1 / (1 + starting)
    else:
        currentWheigt = 1

    if char in dict:
        dict[char] += currentWheigt
    else:
        dict[char] = currentWheigt

print(max(dict,key=dict.get))