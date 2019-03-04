d, b = [int(i) for i in input().split()]
leafs = [int(j) for j in input().split()]
counter = 0


def minimax(branchingFac, noteIndex, deepth, maximazingPlayer, alpha, beta):
    global counter
    counter += 1
    if deepth == 0:
        return leafs[noteIndex],
    if maximazingPlayer:
        maxVal = -100000
        for j in range(branchingFac):
            maxVal = max( minimax(branchingFac, noteIndex * branchingFac + j, deepth - 1, False, alpha, beta), maxVal)
            alpha = max(alpha, maxVal)
            if alpha >= beta: break
        return maxVal
    else:
        minVal = 100000
        for j in range(branchingFac):
            minVal = min(minVal,minimax(branchingFac, noteIndex * branchingFac + j, deepth - 1, True, alpha, beta))
            beta = min(minVal, beta)
            if alpha >= beta: break
        return minVal


bestScore = minimax(b, 0, d, True, -10000, +10000)
print(str(bestScore) + " " + str(counter))
