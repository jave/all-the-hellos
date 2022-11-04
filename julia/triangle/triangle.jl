function valid_triangle(sides)
    gt0 =
    (sides[1]>0 &&
    sides[2]>0 &&
    sides[3]>0)

    ss=sort(sides)
    sgt=ss[1]+ss[2]>ss[3]
    
    gt0 && sgt
end

function is_equilateral(sides)
    sides[1]==sides[2]==sides[3]  && valid_triangle(sides)
end

function is_isosceles(sides)
    length(Set(sides))<=2 && valid_triangle(sides)
end

function is_scalene(sides)
        length(Set(sides))==3 && valid_triangle(sides)
end
