op_bowls = [int(i) for i in input().split()]
my_bowls = [int(i) for i in input().split()]
num = int(input())
currentGrains = my_bowls[num]
my_bowls[num] = 0
pos = num + 1
myBowl = True
while currentGrains != 0:

    if pos == 6 and myBowl == False:
        pos = 0
        myBowl = True
    elif pos == 7 and myBowl == True:
        pos = 0
        myBowl = False

    if myBowl == True:
        my_bowls[pos] += 1
    else:
        op_bowls[pos] += 1

    currentGrains -= 1
    pos += 1

print(*op_bowls[:-1], "[" + str(op_bowls[-1]) + "]")    
print(*my_bowls[:-1], "[" + str(my_bowls[-1]) + "]") 
if (pos == 7):
    print("REPLAY")