function bob(stimulus)
    stimulus=strip(stimulus)
    if match(r"^[ ABCDEFGHIJKLMNOPQRSTUVWXYZÅÄÖ]+\?$", stimulus)!=nothing
        "Calm down, I know what I'm doing!"
    elseif match(r"[ABCDEFGHIJKLMNOPQRSTUVWXYZÅÄÖ]", stimulus)!=nothing && match(r"[abcdefghijklmnopqrstuvwxyzåäö]", stimulus)==nothing
        "Whoa, chill out!"
    elseif match(r"\?$", stimulus)!=nothing
          "Sure."
    elseif stimulus == ""
        "Fine. Be that way!"
    else
        "Whatever."
    end
end
