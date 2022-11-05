function isdivisable(x,y)
    mod(x,y) == 0
end

function factorization(n)
    factors = []
    for i in 1:n-1
        if isdivisable(n,i) push!(factors,i) end
    end
    factors
end

function aliquoth(n)
    f=factorization(n)
    if isempty(f)
        0 # sum of empty set 0
    else
        sum(f)
    end;
end

function isnatural(n)
    if n<1  throw(DomainError(n)) end # not natural number
end

function isperfect(n)
    isnatural(n)
    n==aliquoth(n)
end

function isabundant(n)
    isnatural(n)
    aliquoth(n)>n
end

function isdeficient(n)
    isnatural(n)
    aliquoth(n)<n
end

# this solution is much more interesting:
# https://exercism.io/tracks/julia/exercises/perfect-numbers/solutions/1459c18eafab4ec3b89af8bcd2c237d6

# function factors(n)
#     if n < 1
#         throw(DomainError(n))
#     end
    
#     isfactor(f) = n % f == 0

#     filter(isfactor, 1:(n ÷ 2))
# end

# aliquot_sum = sum ∘ factors
# aliquot_sum_is(op) = (n) -> op(aliquot_sum(n), n) 

# isperfect = aliquot_sum_is(==)
# isabundant = aliquot_sum_is(>)
# isdeficient = aliquot_sum_is(<)
