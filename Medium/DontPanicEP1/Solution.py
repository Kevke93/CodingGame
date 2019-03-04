
*_,e, p,_,_,m=[int(i)for i in input().split()]
F={e:p}
F.update([i,0] for i in range(e-1))
F.update(input().split() for i in range(m))
print(F)
while 1:
    c,P, d = input().split()
    d=d[0]
    c=int(c)
    P=int(P)
    a="WAIT"
    if(d=='L'and F[c]>P)or(d=='R' and F[c]<P):
        a="BLOCK"
    print(a)