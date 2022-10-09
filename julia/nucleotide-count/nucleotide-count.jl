"""
    count_nucleotides(strand)

The frequency of each nucleotide within `strand` as a dictionary.

Invalid strands raise a `DomainError`.

"""
function count_nucleotides(strand)
    nuc=Dict('A' => 0, 'C' => 0, 'G' => 0, 'T' => 0)
    for c in strand
        if !(c in keys(nuc))
            throw(DomainError(c))
        end
        nuc[c]+=1
    end
    nuc
end

"""
x['A']+=1
"asdf"[1]
"""
