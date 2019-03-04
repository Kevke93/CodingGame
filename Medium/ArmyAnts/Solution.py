n1, n2 = [int(i) for i in input().split()]
s1, s2, t = input(), input(), input()
order =list(s1[::-1] + s2)

for _ in range(int(t)):
    i=0
    while i<len(order)-1:
        if order[i] in s1 and order[i + 1] in s2:
            order[i], order[i + 1] = order[i + 1], order[i]
            i += 1
        i+=1

print(*order,sep="")
