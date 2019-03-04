FINAL_SCORE = 101
n = int(input())
player = [input() for _ in range(n)]
winner = []
for i in range(n):
    shoots = input().split()
    score, nbRounds, nbShoot, nbMisses, roundScore = 0, 0, 0, 0, 0
    for shoot in shoots:
        if shoot == 'X':
            if nbMisses == 0:
                score -= 20
            elif nbMisses == 1:
                score -= 30
            else:
                score = 0
            nbMisses += 1
        else:
            nbMisses = 0
            if shoot.isdigit():
                roundScore += int(shoot)
            else:
                roundScore += int(shoot[0]) * int(shoot[2:])
        nbShoot += 1

        if FINAL_SCORE - score - roundScore == 0:
            winner.append((nbRounds + 1, player[i]))
            break
        elif FINAL_SCORE - score - roundScore < 0:
            nbRounds += 1
            nbShoot, roundScore, nbMisses = 0, 0, 0
        elif nbShoot == 3:
            if FINAL_SCORE - score - roundScore > 0:
                score += roundScore
            nbRounds += 1
            roundScore, nbMisses, nbShoot = 0, 0, 0
print(sorted(winner)[0][1])