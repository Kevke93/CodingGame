import sys
import math

n = int(input())
m = int(input())

dict = {}
for i in range(n):
    person_name, nb_vote = input().split()
    dict[person_name] = {}
    dict[person_name]["Vote"] = int(nb_vote)
    dict[person_name]["Yes"] = 0
    dict[person_name]["No"] = 0

for i in range(m):
    voter_name, vote_value = input().split()

    if voter_name in dict.keys():
        if vote_value == "Yes":
            dict[voter_name]["Yes"] += 1
        elif vote_value == "No":
            dict[voter_name]["No"] += 1

yesCoutner = 0
noCoutner = 0
for key in dict.keys():
    if dict[key]["Vote"] >= dict[key]["No"] + dict[key]["Yes"]:
        yesCoutner += dict[key]["Yes"]
        noCoutner += dict[key]["No"]

print(str(yesCoutner) + " " + str(noCoutner))