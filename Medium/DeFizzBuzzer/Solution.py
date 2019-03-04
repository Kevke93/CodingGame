# Create all The Solution for the  based on the given rules from 1:1000
def createDic():
    memoDic = {}
    for i in range(3, 1001):
        current_fizz, current_buzz = 0, 0
        if i % 3 == 0:
            remainder = i
            while remainder % 3 == 0:
                current_fizz += 1
                remainder //= 3
        if i % 5 == 0:
            remainder = i
            while remainder % 5 == 0:
                current_buzz += 1
                remainder //= 5
        current_fizz += str(i).count('3')
        current_buzz += str(i).count('5')
        if current_fizz + current_buzz != 0:
            if not str(current_fizz) + ":" + str(current_buzz) in memoDic.keys():
                memoDic[str(current_fizz) + ":" + str(current_buzz)] = i
            else:
                memoDic[i] = 'ERROR'
    return memoDic


memoDic = createDic()

for i in range(int(input())):
    row = input()
    fizz_count, buzz_count = row.count('Fizz'), row.count('Buzz')
    if str(fizz_count) + ":" + str(buzz_count) in memoDic.keys():
        print((memoDic[str(fizz_count) + ":" + str(buzz_count)]))
    elif not row.isdigit() or int(row) in memoDic.keys():
        print('ERROR')
    else:
        print(row)