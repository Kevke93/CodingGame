# solution: Create line equations for the connections between the points and take the xRay algorithmus to find out
# if the point is in the n-Eck
n = int(input())
# x followed by y coordinate
cornerPoints = []
for i in range(n):
    cornerPoints.append([int(j) for j in input().split()])
cornerPoints.append(cornerPoints[0])
# line equation of that format y = mx+b, m and b are saved in the line equation list
line_equations = []
iterPoints = iter(cornerPoints)

for i in range(n):
    x1, y1 = cornerPoints[i]
    x2, y2 = cornerPoints[i + 1]
    if x1 == x2:
        line_equations.append(("YParralel", x1, y1, x2, y2))
    else:
        m = (y1 - y2) / (x1 - x2)
        b = y1 - m * x1
        line_equations.append((m, b, x1, y1, y2, x2))

m = int(input())
for i in range(m):
    xPoint, yPoint = [int(j) for j in input().split()]
    crossings = 0
    # search directioon positiv
    hitPoint = []
    for equation in line_equations:
        if equation[0] == 'YParralel':
            _, x1, y1, x2, y2 = equation
            if equation[1] >= xPoint and yPoint >= min(y1, y2) and yPoint <= max(y1, y2):

                if not (x1, y1) in hitPoint and not (x2, y2) in hitPoint:
                    crossings += 1
                    if y1 == yPoint:
                        hitPoint.append((x1, y1))
                    elif y2 == yPoint:
                        hitPoint.append((x2, y2))

        else:
            m, b, x1, y1, y2, x2 = equation

            if yPoint == m * xPoint + b and yPoint >= min(y1, y2) and yPoint <= max(y1, y2) \
                    and xPoint >= min(x1, x2) and xPoint <= max(x1, x2):
                crossings = 1
                break

            if m == 0:
                if b == yPoint and xPoint < min(x1, x2):
                    if not (x1, y1) in hitPoint and not (x2, y2) in hitPoint:
                        crossings += 1
                        hitPoint.append((x2, y2))
                        hitPoint.append((x1, y1))
            else:

                if (yPoint - b) / m > xPoint and yPoint >= min(y1, y2) and yPoint <= max(y1, y2):

                    if not (x1, y1) in hitPoint and not (x2, y2) in hitPoint:
                        crossings += 1
                        if y1 == yPoint:
                            hitPoint.append((x1, y1))
                        elif y2 == yPoint:
                            hitPoint.append((x2, y2))
    if crossings % 2 == 0:
        print('miss')
    else:
        print('hit')
