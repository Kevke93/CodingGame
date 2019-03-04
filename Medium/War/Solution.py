import sys
from collections import deque

p1_queue, p2_queue = deque(), deque()
translate = {"2": 2, "3": 3, "4": 4, "5": 5, "6": 6, "7": 7, "8": 8, "9": 9, "10": 10, "J": 11, "Q": 12, "K": 13,
             "A": 14
             }

def fight():
    if p1_queue[0] > p2_queue[0]:
        p1_queue.append(p1_queue.popleft())
        p1_queue.append(p2_queue.popleft())

    elif p1_queue[0] < p2_queue[0]:
        p2_queue.append(p1_queue.popleft())
        p2_queue.append(p2_queue.popleft())
    else:
        war()
    return


def war():
    p1_cards = deque()
    p2_cards = deque()
    while True:
        if len(p1_queue) < 5 or len(p2_queue) < 5:
            print("PAT")
            sys.exit(0)
        p1_cards.extend([p1_queue.popleft() for _ in range(4)])
        p2_cards.extend([p2_queue.popleft() for _ in range(4)])

        if p1_queue[0] > p2_queue[0]:
            p1_cards.append(p1_queue.popleft())
            p2_cards.append(p2_queue.popleft())
            p1_queue.extend(p1_cards)
            p1_queue.extend(p2_cards)
            return
        elif p1_queue[0] < p2_queue[0]:
            p1_cards.append(p1_queue.popleft())
            p2_cards.append(p2_queue.popleft())
            p2_queue.extend(p1_cards)
            p2_queue.extend(p2_cards)
            return


n = int(input())  # the number of cards for player 1
for i in range(n):  # the n cards of player 1
    p1_queue.append(translate[input()[:-1]])

m = int(input())  # the number of cards for player 2
for i in range(m):
    p2_queue.append(translate[input()[:-1]])  # the m cards of player 2

turn = 0

while len(p1_queue) != 0 and len(p2_queue) != 0:
    fight()
    turn += 1
if len(p2_queue) == 0:
    print(f"1 {turn}")
else:
    print(f"2 {turn}")
