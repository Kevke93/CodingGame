import math

frog_number = int(input())
frogs_distance = [float(i) for i in input().split()]
initial_position = [float(i) for i in input().split()]
mass = int(input())
alpha = int(input())
speed = float(input())
gravity = [float(i) for i in input().split()]

speed_x = math.cos(math.radians(alpha)) * speed
speed_y = math.sin(math.radians(alpha)) * speed

delta = speed_y**2 - 2 * gravity[1] * initial_position[1]
time = (-speed_y - delta**0.5)/(gravity[1])

x_final = round(speed_x * time + initial_position[0], 2)

frogs_distance.append(x_final)
frogs_distance.sort(reverse=True)
print(frogs_distance.index(x_final) + 1)
        