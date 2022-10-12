function collatz_steps(n, acc=0)
    if n < 1
        throw(DomainError(n))
    elseif n==1
        acc
    elseif iseven(n)
        collatz_steps(div(n,2),acc+1)
    else
        collatz_steps(n*3+1,acc+1)
    end
end
