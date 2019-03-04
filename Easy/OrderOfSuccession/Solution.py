import sys
import math


class node:
    def __init__(self, *args):
        args = args[0]
        self.name = args[0]
        self.parent = args[1] if args[1] != "-" else None
        self.birth = int(args[2])
        self.death = args[3] if args[3] != "-" else None
        self.religion = args[4] if args[4] != "-" else None
        self.gender = 1 if args[5] == "M" else 0
        self.childList = []

    def findChildren(self, allPeople):
        for people in allPeople:
            if people.parent == self.name:
                self.childList.append(people)



def keyOfSucc(person):
    return person.gender*10000+ (2018-person.birth)**2


def orderOfSucess(childList):
    if len(childList) == 0:
        return

    childList.sort(key = keyOfSucc, reverse=True)

    for person in childList:

        if person.religion != "Catholic" and person.death is None:
            print(person.name)
        orderOfSucess(person.childList)
    return


n = int(input())
allPeople = []
startNode = None
for i in range(n):
    allPeople.append(node(input().split()))
    
    if allPeople[i].parent is None:
        startNode = allPeople[i]
for people in allPeople:
    people.findChildren(allPeople)


orderOfSucess([startNode])


