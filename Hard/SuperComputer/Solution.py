#Greedy Algorithmus Interval_scheduling 0(n*logn)
#Find the global minimum by sorting the scedule list by their endtime
#Go through the list and take all possible Projects
project=[]
for i in range(int(input())):
    start, dur = [int(j) for j in input().split()]
    project.append((start+dur,start))
project.sort()
counter,currentEndtime=0,0
for i,x in enumerate(project):
    if x[1]>=currentEndtime:
        counter+=1
        currentEndtime=x[0]
print(counter)