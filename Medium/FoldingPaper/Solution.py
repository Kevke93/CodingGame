orders = [x for x in input()]
side = input()
U_D = ("U", "D")
R_L = ("R", "L")
score = {'R': 1, 'L': 1, 'D': 1, 'U': 1}

for order in orders:

    if not order in U_D:
        score['U'] *= 2
        score['D'] *= 2
        score[R_L[abs(R_L.index(order) - 1)]] = score['L'] + score['R']
    elif not order in R_L:
        score['L'] *= 2
        score['R'] *= 2
        score[U_D[abs(U_D.index(order) - 1)]] = score['D'] + score['U']
    score[order] = 1

print(score[side])
