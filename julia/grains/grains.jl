function check_valid_square(square)
    square in 1:64 || throw(DomainError(square, "square should be in range 1:64"))
end

"""Calculate the number of grains on square `square`."""
function on_square(square)
    check_valid_square(square)
    Int128(2)^(square-1)
end

"""Calculate the total number of grains after square `square`."""
function total_after(square)
    check_valid_square(square)
    mapreduce(on_square, +, [1:square;])
end
