isdivisable <- function(x,y) {
    x %% y == 0;
}

leap <- function(year) {
    isdivisable(year, 4) && ! (isdivisable(year, 100)) || isdivisable(year, 400);
}
