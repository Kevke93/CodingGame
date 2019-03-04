def kürzen(a, b, c):
    for i in range(min([abs(a), abs(b), abs(c)]), 0, -1):
        if a % i == 0 and b % i == 0 and c % i == 0:
            return [a // i, b // i, c // i]
    return [a, b, c]


xA, yA, xB, yB = [int(i) for i in input().split()]
n = int(input())

lines = []
crossedLines=0

for i in range(n):
    a, b, c = [int(j) for j in input().split()]
    
  
    equationShort = kürzen(a, b, c)
    equationShortMinus = [-1*x for x in equationShort]
    if not (equationShort in lines) and not (equationShortMinus in lines):
        lines.append(equationShort)
        if xA * a + yA * b + c == 0 or xB *a + yB * b + c == 0:
            print('ON A LINE')
            exit(0)
    # Check if t
        if (xA*a+yA*b+c)*(xB*a+yB*b+c)<0:
            crossedLines+=1
     
if crossedLines%2 == 0:
    print('YES')
else:
    print('NO')

