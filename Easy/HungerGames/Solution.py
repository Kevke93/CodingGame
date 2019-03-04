tributes = int(input())
players = {input(): {'killed': [], 'killer': []} for _ in range(tributes)}

for _ in range(int(input())):
    turn = input().replace(",", "").split()

    for j in range(2, len(turn)):
        players[turn[0]]['killed'].append(turn[j])
        players[turn[j]]['killer'].append(turn[0])

counter = 0
for key, value in sorted(players.items(), key=lambda x: x[0]):
    print(f"Name: {key}")
    print("Killed: None") if len(value['killed']) == 0 else print("Killed: " + ", ".join(sorted(value['killed'])))
    print("Killer: Winner") if len(value['killer']) == 0 else print("Killer: " + ", ".join(sorted(value['killer'])))

    if counter < tributes - 1:
        print()
        counter += 1