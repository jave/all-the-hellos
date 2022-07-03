def square(number:int):
    if number < 1 or number > 64:
        raise ValueError("square must be between 1 and 64")
    return  pow(2, number-1)



def total(n=64):
    return pow(2,n)-1
