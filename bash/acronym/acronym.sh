#!/usr/bin/env bash

input=$1
output=""

#convert - to ' ', according to specs
input=$(echo "$input" | tr '-' ' ')

#traverse all words in input
for word in $input; do
    #get the initial letter from the word, ucase it
    letter=$(echo $word|head -c 1| tr '[:lower:]' '[:upper:]')
    output+=$letter
done

echo $output
