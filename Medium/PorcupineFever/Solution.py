amountCages, years = int(input()), int(input())
cages = {}
for i in range(amountCages):
    s, h, a = [int(j) for j in input().split()]
    cages[i] = {'sick': s, 'healthy': h, 'alive': a}

for _ in range(years):
        alive = 0
        for values in cages.values():
            if values['alive'] > 0:
                values['alive'] -= values['sick']
                values['sick'] = values['sick'] * 2 if values['healthy'] >= values['sick'] * 2 else values['healthy']
                values['healthy'] = values['alive'] - values['sick']
                alive += values['alive']
        print(alive)
        if alive == 0:
            break
