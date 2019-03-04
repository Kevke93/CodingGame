import sys
import math

def calcDist(x1,x2,y1,y2):
    y=(y1-y2)**2
    x=(x1-x2)**2
    res=(y+x)**0.5

    return res

def checkPythagoras(x1,x2,x3,y1,y2,y3):
    AtoB=calcDist(x1,x2,y1,y2)
    BtoC=calcDist(x2,x3,y2,y3)
    CtoA=calcDist(x1,x3,y1,y3)

    if abs(AtoB**2+BtoC**2 -CtoA**2)<0.01 :
        return True
    return False


n = int(input())
for i in range(n):
    a, x_a, y_a, b, x_b, y_b, c, x_c, y_c, d, x_d, y_d = input().split()
    xA = int(x_a)
    yA = int(y_a)
    xB = int(x_b)
    yB = int(y_b)
    xC = int(x_c)
    yC = int(y_c)
    xD = int(x_d)
    yD = int(y_d)


    def checkRhombus():
        if calcDist(xA, xB, yA, yB)==calcDist(xC, xB, yC, yB)==calcDist(xC, xD, yC, yD)==calcDist(xA, xD, yA, yD):
            return True
        else:
            return False
    def checkRegtangle():
        if (True == checkPythagoras(xA,xB,xC,yA,yB,yC) == checkPythagoras(xB,xC,xD,yB,yC,yD)
                == checkPythagoras(xC,xD,xA,yC,yD,yA) == checkPythagoras(xD,xA,xB,yD,yA,yB)):
            return True
        else:
            return False



    def checkParalelogramm():
        if (xA - xB == xD - xC and yA - yB == yD - yC and yB - yC == yA - yD and xB - xC == xA - xD):
            return True
        else:
            return False


    if checkRhombus() and checkRegtangle():
        output="square"
    elif checkRegtangle():
        output="rectangle"
    elif checkRhombus() :
        output="rhombus"
    elif checkParalelogramm():
        output="parallelogram"
    else:
        output="quadrilateral"

    print(str(a) + str(b) + str(c) + str(d) + " is a "+ output+".")
