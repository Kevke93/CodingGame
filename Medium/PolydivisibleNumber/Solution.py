def polydivisible(numbB10):
    for i in range(1, len(str(numbB10))+1):
        if int(str(numbB10)[:i]) % i != 0:
            return False
    return True


rawString = input().split()
for i in range(max([int(x)for x in rawString])+1,36):
    numB10=0
    for x in rawString :
        numB10=numB10*i+int(x)
    if polydivisible(numB10):
        print(i)