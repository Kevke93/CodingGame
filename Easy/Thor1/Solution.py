 the standard input according to the problem statement.
# ---
# Hint: You can use the debug stream to print initialTX and initialTY, if Thor seems not follow your orders.# light_x: the X position of the light of power
# light_y: the Y position of the light of power
# initial_tx: Thor's starting X position
# initial_ty: Thor's starting Y position
light_X, light_Y, initialTX, initialTY = [int(i) for i in input().split()]
# game loop
while True:
    remaining_turns = int(input())  # The remaining amount of turns Thor can move. Do not remove this line.
    if light_X > initialTX:
        if light_Y > initialTY:
            print("SE")
            initialTY = initialTY + 1
        elif light_Y < initialTY:
            print("NE")
            initialTY = initialTY - 1
        elif light_Y == initialTY:
            print("E")
        initialTX = initialTX + 1
    elif light_X < initialTX:
        if light_Y > initialTY:
            print("SW")
            initialTY = initialTY + 1
        elif light_Y < initialTY:
            print("NW")
            initialTY = initialTY - 1
        elif light_Y == initialTY:
            print("W")
        initialTX = initialTX - 1
    else:
        if light_Y > initialTY:
            print("S")
            initialTY = initialTY + 1
        elif light_Y < initialTY:
            print("N")
            initialTY = initialTY - 1
