# the dart exercise

function score(x, y)
    # you can do lambda like things, which is nice
    norm(x1, y1) = sqrt(sum(x1^2 + y1^2))

    # you can do short circuit style operations
    norm(x, y) <= 1 && return 10
    norm(x, y) <= 5 && return 5
    norm(x, y) <= 10 && return 1

    # and if none of the short circuits matched, return 0
    return 0
end
