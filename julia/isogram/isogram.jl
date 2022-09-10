function isisogram(s)
    s=replace(s, r"[- ]" => "")
    length(s)==length(Set(collect(lowercase(s))))
end
