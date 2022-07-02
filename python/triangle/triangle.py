def valid_triangle(sides):
    print(sides)
    gt0 = (sides[0]>0 and
           sides[1]>0 and
           sides[2]>0)
    sides.sort()
    ss=sides
    sgt=ss[0]+ss[1]>ss[2]
    
    return gt0 and sgt



def equilateral(sides):
    return sides[1]==sides[2]==sides[0]  and valid_triangle(sides)


def isosceles(sides):
    return len(set(sides))<=2  and valid_triangle(sides)


def scalene(sides):
    return len(set(sides))==3  and valid_triangle(sides)
