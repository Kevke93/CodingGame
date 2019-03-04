import sys
import math


def prim(number):
    def primeRekursiv(number, current):

        if number % current == 0:
            return False
        if (int(number / (current - 1)) <= current):
            return True

        return primeRekursiv(number, current + 2)

    if number % 2 == 0:
        return False
    else:
        return primeRekursiv(number, 3)


n = int(input())

if (prim(n)):
    print("NO")
else:
    calNum = "YES"
    for a in range(2,n):
        if pow(a,n,n) !=a :
            calNum = "NO"
            break

    print(calNum)
