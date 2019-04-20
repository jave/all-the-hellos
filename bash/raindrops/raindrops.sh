#!/usr/bin/env bash

input=$1
output=""

if [[ $(($input % 3)) == 0 ]] ; then
    output=${output}"Pling"
fi

if [[ $(($input % 5)) == 0 ]] ; then
    output=${output}"Plang"
fi

if [[ $(($input % 7)) == 0 ]] ; then
    output=${output}"Plong"
fi

if [[ $output == "" ]] ; then
    output=$input
fi    

echo $output
