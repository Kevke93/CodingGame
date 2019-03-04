import sys
import math
import re

def inToStr(numb,base):
    convertString = "0123456789AB"
    if numb < base:
        return convertString[numb]
    
    return inToStr(numb//base,base)+convertString[numb%base]
    

n = int(input())
dict={"Jan":"0",
    "Feb":"1",
    "Mar":"2",
    "Apr":"3",
    "May":"4",
    "Jun":"5",
    "Jul":"6",
    "Aug":"7",
    "Sep":"8",
    "Oct":"9",
    "Nov":"A",
    "Dec":"B",
    }

addition=0
for _ in range(n):
    temp=""
    inp=input()
    for i,word in enumerate(re.findall('[A-Z][^A-Z]*',inp)):
        temp+=dict[word]
    addition+=(int(temp,base=12))


result=""
for x in inToStr(addition,12):
    for key,value in dict.items():
        if(x==value):
            result+=key
            break
print(result)
