#!/usr/bin/env bash

# The Collatz Conjecture or 3x+1 problem can be summarized as follows:

# Take any positive integer n. If n is even, divide n by 2 to get n /
# 2. If n is odd, multiply n by 3 and add 1 to get 3n + 1. Repeat the
# process indefinitely. The conjecture states that no matter which
# number you start with, you will always reach 1 eventually.

# Given a number n, return the number of steps required to reach 1.


# ok so why cant i do [[ $1 > 0]] ?
# why cant then else be empty?
# why is n=1 ok, but not n = 1 ?
# bash is odd

if [[ $1 -gt 0 ]]; then
    n=$1
else
    echo "Error: Only positive numbers are allowed"
    exit 1
fi


step=0
while [[ $n != 1 ]] ; do
    if [[ $((n % 2)) == 0 ]] ; then #even
        n=$(( $n / 2))
    else
        n=$(( $n * 3 + 1))
    fi
#    echo "n: $n step: $step"
    step=$(( $step + 1))
done

echo $step
