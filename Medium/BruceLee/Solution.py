encrypt = input().split()
if len(encrypt) % 2 == 1:
    print('INVALID')
    exit(0)
message = [(encrypt[i], encrypt[i + 1]) for i in range(0, len(encrypt), 2)]
reuslt = ""
for bite, amount in message:
    if bite != '0' and bite != '00':
        print('INVALID')
        exit(0)
    reuslt += ("1" if bite == "0" else "0") * amount.count("0")
if len(reuslt) % 7 != 0:
    print("INVALID")
else:
    print("".join(chr(int(reuslt[i:i + 7], 2)) for i in range(0, len(reuslt), 7)))
