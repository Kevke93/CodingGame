for i in range(int(input())):
    card = input().replace(" ","")
    sum =0
    for i in range(len(card)-1,-1,-1):
        if i%2==0:
            num =int(card[i])*2
            sum+=num if num<10 else num-9
        else:
            sum+=int(card[i])
    print("YES") if sum%10==0 else print("NO")
  