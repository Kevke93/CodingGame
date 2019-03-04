from collections import OrderedDict

romanDict = {'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C': 100, 'D': 500, 'M': 1000}

def transformToInt(rom):
    res = 0
    for letter in rom:
        res += romanDict[letter]
    for i in range(len(rom) - 1):
        if rom[i] == 'I' and (rom[i + 1] == 'X' or rom[i + 1] == 'V'):
            res -= 2
        elif rom[i] == 'X' and (rom[i + 1] == 'L' or rom[i + 1] == 'C'):
            res -= 20
        elif rom[i] == 'C' and (rom[i + 1] == 'D' or rom[i + 1] == 'M'):
            res -= 200
    return res


def transformToRom(number):
    test = OrderedDict(sorted(romanDict.items(),key = lambda x: x[1], reverse=True))
    res=[]
    while number >0:
        for key,value in test.items():
            if number >=value:
                if number//100==9:
                    res.append('CM')
                    number-=900
                elif number//100==4:
                    res.append('CD')
                    number-=400
                elif number//10  ==9:
                    res.append('XC')
                    number-=90
                elif number//10 ==4:
                    res.append('XL')
                    number-=40
                elif number ==9:
                    res.append('IX')
                    number-=9
                elif number  == 4:
                    res.append("IV")
                    number-=4
                else:
                    res.append(key)
                    number-=value
                break
    return "".join(res)

rom_1 = input()
rom_2 = input()

int_1 = transformToInt(rom_1)
int_2 = transformToInt(rom_2)

print(transformToRom(int_1 + int_2))