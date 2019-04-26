# nothing very clever here

def raindrops(number):
    rv=""
    if(number % 3 == 0):
        rv+="Pling"
    if(number % 5  == 0):
        rv+="Plang"
    if(number % 7  == 0):
        rv+="Plong"
    if(rv==""):
        rv=number
    return "%s"%rv
