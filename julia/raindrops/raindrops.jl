function raindrops(number)
    rv = ""
    rv = rv * (number % 3 == 0 ?  "Pling" : "")
    rv = rv * (number % 5 == 0 ?  "Plang" : "")
    rv = rv * (number % 7 == 0 ?  "Plong" : "")
    if rv == "" rv = string(number) end
    rv
end
