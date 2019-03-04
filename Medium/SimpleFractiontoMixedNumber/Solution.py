import sys
import math


def calcGGT(a,b):
    # Everything divides 0
    if (b == 0): 
         return a 
    return calcGGT(b, a%b) 


n = int(input())
for i in range(n):
    numb = input()

    sign = ""

    if numb.count("-") == 1:
        sign = "-"

    numb = numb.replace("-", "")

    numbList = numb.split("/")
    zaehler = int(numbList[0])
    nenner = int(numbList[1])

    if nenner == 0:
        result = "DIVISION BY ZERO"
    elif zaehler == 0:
        result = "0"
    elif zaehler % nenner == 0:
        result = sign + str(int(zaehler / nenner))
    else:
        firstRes = int(zaehler / nenner)
        zaehlerRes = zaehler - firstRes * nenner
        ggt = calcGGT(zaehlerRes, nenner,)
        if (firstRes == 0):

            result = sign + str(int(zaehlerRes / ggt)) + "/" + str(int(nenner / ggt))
        else:
            result = sign + str(firstRes) + " " + str(int(zaehlerRes / ggt)) + "/" + str(int(nenner / ggt))

    print(result)

