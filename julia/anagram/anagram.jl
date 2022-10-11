function detect_anagrams(subject, candidates)
    # 1st delete  candidates identical to subject, ignore case
    deleteat!(candidates, findall(x -> x == lowercase.(subject), lowercase.(candidates)))

    # next, keep only candidates that are anagrams of the subject
    filter( c -> isanagram(subject, c), candidates)
    
end

function isanagram(s,c)
    # figure out if c is an anagram of s, by turning strings to
    # collections, and sorting them, and then comparing the collections
    sort(collect(lowercase(s))) == sort(collect(lowercase(c)))
end
