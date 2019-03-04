def encoding(message):
    newMessage,counter,swap = "", 1, True


    while True:
        counter = min(counter, len(message))

        if (swap):
            newMessage += message[:counter]
        else:
            newMessage = message[:counter] + newMessage

        message = message[counter:]

        if len(message) == 0:
            return newMessage
        counter += 1
        swap = not (swap)


def decoding(message,last,lastLast):

    if lastLast%2==0:
        newMessage=message[-last:]
        message=message[:-last]
        swap = False
    else:
        newMessage = message[:last]
        message = message[last:]
        swap = True

    counter = lastLast

    while counter>0:

        if (swap):
            newMessage = message[-counter:] + newMessage
            message=message[:-counter]
        else:
            newMessage = message[:counter] + newMessage
            message=message[counter:]

        counter-=1
        swap = not (swap)
    return newMessage


def getLastSteps(messageLen):

    counter=1
    while True:
        if messageLen-min(counter,messageLen)==0:
            return [min(counter,messageLen),counter-1]
        else:
            messageLen -= counter
            counter+=1


n = int(input())
message = input()

if(n>0):
    last, lastLast = getLastSteps(len(message))


for i in range(abs(n)):
    if(n<0):
        message = encoding(message)
    else:
        message=decoding(message,last,lastLast)
            
        
print(message)