import sys
import math
import re

def split(poly):
    start, end = "(", ")"
    startsequence = None
    sequences = []
    for i, x in enumerate(poly):
        if x == start:
            startsequence = i + 1
            continue
        if x == end and startsequence is not None:

            sequences.append(poly[startsequence:i])
            if i < len(poly) - 2:
                if poly[i+1]=="^":
                    for y in range(int(poly[i+2])-1):
                        sequences.append(poly[startsequence:i])

            startsequence = None
    return sequences

def transform(term):

    grad =2;
    for i,x in enumerate(term):
        if x=='^':
            grad=int(term[i+1])+1
            break;
    transformedTerm = [0]*grad
    startTerm=0
    for i,x in enumerate(term):
        if x == "+" or x=="-":
            startTerm=i
        if x=='^':
            if startTerm>=i-2:
                if term[startTerm] != "x":
                    transformedTerm[int(term[i + 1])] = int(term[startTerm:i-1])*-1 if term[startTerm]=="-" else int(term[startTerm:i-1])
                else:
                    transformedTerm[int(term[i + 1])]=-1 if term[startTerm]=='-' else 1
            else:
                transformedTerm[int(term[i + 1])]=int(term[startTerm+1:i-1])*-1 if term[startTerm]=='-' else int(term[startTerm+1:i-1])
            startTerm=0
        elif x =="x":
            if i==len(term)-1:
                if (startTerm == 0 and i==0) or startTerm ==i-1:
                    transformedTerm[1]=-1 if term[startTerm]=="-"else 1
                else:
                    transformedTerm[1] = int(term[startTerm + 1:i]) * -1 if term[startTerm] == '-' else int((term[startTerm + 1:i]))
                startTerm = 0
            elif term[i+1]!="^":
                if (startTerm == 0 and i==0) or startTerm ==i-1:
                    if startTerm ==0 and i>0:
                       
                        transformedTerm[1]=int(term[0:i])
                    else:
                        transformedTerm[1] = -1 if term[startTerm] == "-" else 1
                else:
                    transformedTerm[1] = int(term[startTerm + 1:i]) * -1 if term[startTerm] == '-' else int((term[startTerm + 1:i]))
                startTerm = 0
        elif i == len(term)-1 and startTerm!=0:
            transformedTerm[0]=int(term[startTerm+1:i+1])*-1 if term[startTerm] =='-' else int(term[startTerm+1:i+1])

    return transformedTerm

def multi(firstTerm, secondTerm):
    result =[0]*(len(firstTerm)+len((secondTerm))-1)

    for i,x in enumerate(firstTerm):
       for j,y in enumerate(secondTerm):
           if x!=0 and y!=0:
                result[i+j]+=x*y
    return result
def transformBack(sequence):
    result=""
    for i in range(len(sequence)-1,-1,-1):
        if sequence[i]!=0 :
            if sequence[i]>0 and i !=len(sequence)-1:
                result+="+"
            if i == 0 :
                result+=str(sequence[i])
            elif i == 1:
                if sequence[i]>0:
                    result+= str(sequence[i])+"x" if sequence[i]!=1 else "x"
                else:
                    result += str(sequence[i]) + "x" if sequence[i] != -1 else "-x"
            else:
                if sequence[i]>0:
                    result+=str(sequence[i])+"x^"+str(i) if sequence[i]!=1 else "x^"+str(i)
                else:
                    result += str(sequence[i]) + "x^" + str(i) if sequence[i] != -1 else "-x^" + str(i)
    return result

poly = input()
sequence= split(poly)
sequence= [transform(i) for i in sequence]

while len(sequence)>1:
    sequence[0]=multi(sequence[0],sequence[1])
    sequence.pop(1)



print (transformBack(sequence[0]))
