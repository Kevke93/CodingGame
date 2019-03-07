lenght = int(input())
n = int(input())
field = [["0"]*4 for _ in range(lenght)]
for i in range(n):
    pattern, tempo = input().split()
    tempo = int(tempo)

    for j in range(lenght):
        if (j+1) % tempo == 0:
            for k in range(4):
                if pattern[k] == "X":
                    field[lenght-1-j][k] = "X"
for j in range(lenghtl):
    print("".join(field[j]))
