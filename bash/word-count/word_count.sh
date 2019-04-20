#!/usr/bin/env bash

# this code misses 2 of the test cases
# - the one with lots of funny chars
# - the one with 'quotedword'

#   ignore punctuation 6/11 - ignore punctuation (skipped)
#   with quotations10/11 - with quotations (skipped)

input_raw=$1
# i wanted to use substitution groups but didnt know how to do this in bash
input_raw=${input_raw//[[:space:]]\'/ } 
input_raw=${input_raw//\'[[:space:]]/ } 

#input_raw=${input_raw//[@&!$%^:.]/}

input=$(echo "$input_raw"|tr -c "[:alpha:][:digit:]\'" '\n'|tr '[:upper:]' '[:lower:]')



# why does quoting affect output?
unique_words=$(echo "$input"|sort|uniq )
 # echo "input_raw: $1"
 # echo "input: $input"
 # echo "uniq:  $unique_words"

#echo $unique_words

for word in $unique_words; do
    count=$(echo $input|grep --only-matching $word|wc -w)
    echo "$word: $count"
    
done
