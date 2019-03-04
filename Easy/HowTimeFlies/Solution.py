import sys
import math


def dateNumber(d, m, y,):
    """ Calculate the Amoun of Days"""
    if m == 1 or m ==2:
        m+=12
        y-=1

    return 365*y + int(y/4) - int(y/100) + int(y/400) + d + int((153*m+8)/5)

def formatOutput( number, format):
    """ format the Output for month and years"""
    if number == 1:
        return str(number)+ " "+format
    elif number == 0:
        return ""
    else:
        return str(number) + " " + format + "s"


begDay, begMonth, begYear = input().split(".")
endDay, endMonth, endYear = input().split(".")

begDay = int(begDay)
begMonth = int(begMonth)
begYear = int (begYear)
endDay = int(endDay)
endMonth = int (endMonth)
endYear = int (endYear)

print(begDay, begMonth, begYear, file=sys.stderr)
print(endDay, endMonth, endYear, file=sys.stderr)

dateDiff = int(abs(dateNumber(begDay, begMonth, begYear) - dateNumber(endDay, endMonth, endYear)))


yearDiff = 0
monthDiff = 0


""" Hier ist wahrscheinlich irgendwo der Fehler aber ich kaum da irgendwie nicht drauf"""
if begDay > endDay :
    monthDiff = 12 + endMonth - begMonth - 1
    # monthDiff = endMonth % 12 - (begMonth+1) % 12
else:
    monthDiff = 12 + endMonth - begMonth
    # monthDiff = endMonth % 12 - begMonth  % 12
monthDiff %= 12


if endYear > begYear:
    if endMonth < begMonth:
        yearDiff = endYear -begYear -1
    elif endMonth == begMonth and begDay > endDay:
        yearDiff = endYear -begYear -1
    else:
        yearDiff = endYear - begYear




if dateDiff == 1 :
    outDay=str(dateDiff)+ " day"
elif dateDiff == 0 :
    outDay="0 days"
else:
    outDay = str(dateDiff) + " days"

outMonth= formatOutput( monthDiff, "month")
outYear = formatOutput(yearDiff, "year")

if yearDiff ==0 and monthDiff == 0 :
    print("total "+ outDay)
elif yearDiff == 0:
    print (outMonth +", " + "total "+ outDay)
elif monthDiff == 0:
    print (outYear +", " + "total "+ outDay)
else:
    print(outYear + ", "+outMonth+", " + "total "+ outDay)
