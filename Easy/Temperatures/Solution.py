n = int(input()) 
a =[int(i)for i in input().split()]
min=5527
for i in a:
    if(abs(i)<abs(min)):
        min=i
    if(abs(i)==abs(min) and i>min):
        min=i
if(min==5527):
    print(0)
else:
    print(min)