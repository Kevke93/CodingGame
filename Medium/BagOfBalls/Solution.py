import math


def binominalFac(n, k):
    return math.factorial(n) / (math.factorial(k) * math.factorial(n - k))


def shorten(a, b):
    a, b = int(a), int(b)

    def calcFac(a, b):
        a, b = max(a, b), min(a, b)
        while b:
            a, b = b, a % b
        return a

    fac = calcFac(a, b)
    return a // fac, b // fac


n, w, s, k = int(input()), int(input()), int(input()), int(input())

prob_numerator = binominalFac(w, k) * binominalFac(n - w, s - k)
prob_against_numerator = binominalFac(n, s) - prob_numerator

if prob_against_numerator == 0:
    print("1:0")
else:
    prob_short, prob_against_short = shorten(prob_numerator, prob_against_numerator)
    print(f"{prob_short}:{prob_against_short}")
