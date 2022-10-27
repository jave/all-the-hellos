#=
calculate pascals triangle
looks like this:
    1
   1 1
  1 2 1
 1 3 3 1
1 4 6 4 1

But you can also view it like this, and then each cell is 
calculated by the binomial function
1
1 1
1 2 1
1 3 3 1
1 4 6 4 1

You can write this as a julia list comprehension, see below
=#


function triangle(trianglerows::Int)
    trianglerows < 0 && throw(DomainError(trianglerows))
    [ [binomial(m, k) for k in 0:m] for m in 0:trianglerows-1 ]
end
