#!/usr/bin/env bash


# bob exercise, interpret input in different ways

# fn that prints what bo wants to say
function bob_says {
    echo $1
}

function bob_exits {
    exit 0
}

# echo "hello";

# bob_says "testar lite"

# %b interprets escapes like \n, which one of the testcases use

# tst="lalala\ntst"
input="$(printf %b $1)"

# ignore spaces
input="${input//[[:space:]]/}"

#echo "input: $input"

# check if input consist of empty string after ws is removed
# input="lala" 

function dad_is_silent {
    [ "${1}" == "" ]
}

function dad_is_asking {
    [ "${1: -1}" == "?" ]
}

function dad_is_shouting {
    [[ $1 =~ [[:upper:]] &&  ! $1 =~ [[:lower:]] ]]
}

if dad_is_silent $input ; then
    bob_says "Fine. Be that way!"
    bob_exits
fi

if dad_is_shouting $input &&  dad_is_asking $input ; then
    bob_says "Calm down, I know what I'm doing!"
    bob_exits
fi

if dad_is_asking $input ; then
    bob_says "Sure."
    bob_exits
fi

if dad_is_shouting $input ; then
    bob_says "Whoa, chill out!"
    bob_exits
fi

echo "Whatever."
