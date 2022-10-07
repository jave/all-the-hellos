"Your optional docstring here"
function distance(a, b)
    d=0
    if length(a) != length(b)
        throw(ArgumentError("not the same lengths"))
    end
    for i in 1:length(a)
       if a[i] != b[i]
           d+=1
       end
    end
    d
end

#more interestnig
#https://exercism.io/tracks/julia/exercises/hamming/solutions/cb6b5e58983843f0bf118c36d8a7bb6c
# function distance(a, b)

#   if length(a) != length(b)
#     throw(ArgumentError("Mismatch string length"))
#   end

#   a = collect(a)
#   b = collect(b)
  
#   sum(collect(a) .!= collect(b))

# end
