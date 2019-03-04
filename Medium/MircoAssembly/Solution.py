transform = {"a": 0, "b": 1, "c": 2, "d": 3}


def move(register, instruction):
    _, desti, value = instruction.split()
    if not (value.isdigit()) and value[0]!="-":
        value = register[transform[value]]
    register[transform[desti]] = int(value)
    return register


def add(register, instruction, sign):
    _, desti, firstVal, secondVal = instruction.split()

    if not (firstVal.isdigit())and firstVal[0]!="-":
        firstVal = register[transform[firstVal]]
    if not (secondVal.isdigit())and secondVal[0]!="-":
        secondVal = register[transform[secondVal]]
    register[transform[desti]] = int(firstVal) + int(secondVal) * sign
    return register


def jump(register, instruction, pointer):
    _, desti, firstVal, secondVal = instruction.split()

    if not (firstVal.isdigit())and firstVal[0]!="-":
        firstVal = register[transform[firstVal]]
    if not (secondVal.isdigit())and secondVal[0]!="-":
        secondVal = register[transform[secondVal]]

    if int(firstVal) != int(secondVal):
        pointer = int(desti)
    else:
        pointer += 1
    return pointer


register = [int(i) for i in input().split()]
instructions = [input() for _ in range(int(input()))]
pointer = 0


while pointer < len(instructions):
    if instructions[pointer].split()[0] == 'MOV':
        register = move(register, instructions[pointer])
        pointer += 1
    elif instructions[pointer].split()[0] == 'ADD':
        register = add(register, instructions[pointer], 1)
        pointer += 1
    elif instructions[pointer].split()[0] == 'SUB':
        register = add(register, instructions[pointer], -1)
        pointer += 1
    elif instructions[pointer].split()[0] == 'JNE':
        pointer = jump(register, instructions[pointer], pointer)

print(" ".join([str(x) for x in register]))
