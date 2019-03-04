operation = input()
shift = int(input())
rotor = []
rotor.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ")
for _ in range(3):
    rotor.append(input())
message = input()


def encode(shift):
    newMessage = ""
    currentShift = lambda k: shift if i == 1 else 0
    for x in message:
        for i in range(1, 4, 1):
            x = rotor[i][(rotor[0].find(x)+ currentShift(i)) % 26]
        newMessage += x
        shift += 1
    return newMessage


def decode(shift):
    newMessage = ""
    currentShift = lambda k: -shift if i == 1 else 0
    for x in message:
        for i in range(3, 0, -1):
            x = rotor[0][(26+rotor[i].find(x)+currentShift(i)) % 26]
        newMessage += x
        shift += 1
    return newMessage


if operation == "ENCODE":
    print(encode(shift))
else:
    print(decode(shift))