# i want to do a lispy recusive solution
#like
# cdr = iterable[1:]
# car = iterable[0]

def flatten(iterable):

    if len(iterable) == 0: # case of empty list
        return []
    elif iterable[0]==None:
        return flatten(iterable[1:])
    elif not type(iterable[0])==type([]):    # case of 1st item is an element
        return [iterable[0]]+flatten(iterable[1:])
    else:   # case of 1st element is a list
        return flatten(iterable[0]) +flatten(iterable[1:])
