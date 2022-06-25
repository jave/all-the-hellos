ALLERGENS = ["eggs", "peanuts", "shellfish", "strawberries", "tomatoes", "chocolate", "pollen", "cats"]

function allergic_to(score, allergen)
    # if allergen belongs to the set of allergens returned by allergen_list, we are allergic to the allergen
    allergen ∈ allergy_list(score)
end

function allergy_list(score)
    # very similar to the clojure solution i have
    # i kinda dislike the map lambda variant for converting the strings to bools but ok
    allergene_booleans = map(x -> x == '1', collect(reverse(bitstring(score))))

    # zip together allergenes, and allergene boleans, use
    # comprehension to create an array of matching allergenes, convert
    # array to Set
    Set([x for (x, y) in zip(ALLERGENS, allergene_booleans) if y])
end


