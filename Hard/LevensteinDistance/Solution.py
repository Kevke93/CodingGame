word_1, word_2 = input(), input()
len_word_1, len_word_2 = len(word_1), len(word_2)
grid = [[0 for _ in range(len(word_2) + 1)] for _ in range(len(word_1) + 1)]

for i in range(len_word_1 + 1):
    for j in range(len_word_2 + 1):
        if i == 0:
            grid[i][j] = j
        elif j == 0:
            grid[i][j] = i
        elif word_1[i - 1] == word_2[j - 1]:
            grid[i][j] = grid[i-1][j-1]
        else:
            grid[i][j] = 1 + min([grid[i-1][j], grid[i][j-1], grid[i-1][j-1]])
print(grid[len_word_1][len_word_2])
