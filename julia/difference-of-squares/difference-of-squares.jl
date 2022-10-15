"Square the sum of the first `n` positive integers"
function square_of_sum(n)
    sum = 0
    for i in  1:n
        sum = sum + i
    end
    sum^2

end

"Sum the squares of the first `n` positive integers"
function sum_of_squares(n)
    sum = 0
    for i in  1:n
        sum = sum + i^2
    end
    sum

end

"Subtract the sum of squares from square of the sum of the first `n` positive ints"
function difference(n)
    square_of_sum(n) - sum_of_squares(n)
end

# the above solution is julia loop syntax exercising, but you dont actually need the loops
# use expressions for sums instead
# like
# function square_of_sum(n)
#     return (n * (n + 1) ÷ 2) ^ 2
# end

# function sum_of_squares(n)
#     return (n * (n + 1) *  (2 * n + 1) ÷ 6)
# end
