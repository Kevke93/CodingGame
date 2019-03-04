n = int(input())
field = []
for i in range(n):
    compound = " " + input() + " "
    field.append(compound)

valid = True
for i, row in enumerate(field):
    for j, element in enumerate(row):
        if row[j - 1] == 'H':
            needed = 4 - int(element)
            if row[j - 3] == ')':
                needed -= int(row[j - 4])
            if row[j + 1] == '(':
                needed -= int(row[j + 2])
            if i > 0 and j<=len(field[i-1]) and field[i - 1][j] == ')':
                        needed -= int(field[i - 1][j - 1])
            if i < len(field) - 1 and j<=len(field[i+1]) and field[i + 1][j] == ')':
                        needed -= int(field[i + 1][j - 1])
            if needed != 0:
                valid = False
                break

print('VALID' if valid else 'INVALID')
