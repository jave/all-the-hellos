function is_divisable(x::Int,y::Int)
    return x % y == 0;
end

function is_leap_year(year::Int)
    return is_divisable(year, 4) && ! (is_divisable(year, 100)) || is_divisable(year, 400);
end

