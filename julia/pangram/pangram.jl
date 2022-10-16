"""
    ispangram(input)

Return `true` if `input` contains every alphabetic character (case insensitive).

"""
function ispangram(input::AbstractString)
# wash the input, by lowercasing.
#  julia has a "chain" function, https://docs.julialang.org/en/v1/base/base/#Base.:|%3E
# similar to clojure threading macro
    input |>
    lowercase |>
    compare
end

function compare(input::AbstractString)
# here, just create 2 sets, if they are the same, input is a pangram
    Set('a':'z') ⊆ Set(input)
end
