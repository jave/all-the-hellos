#!/usr/bin/env bash

 
input=$1
# this bash 4.0 construct lowercases the input
# https://www.gnu.org/software/bash/manual/bashref.html#Shell-Parameter-Expansion
input="${input,,}"

#okay now all chars are normalized to lowercase
#so now we remove all that is not lowercase
if_empty_then_isogram="${input//[![:lower:]]}"
#echo $if_empty_then_isogram

#now loop over all letters in the range a-z
for letter in {a..z}; do
    # chip away a letter at a time from the input / replaces once, // replaces globally
    if_empty_then_isogram="${if_empty_then_isogram/$letter/}"
#    echo $if_empty_then_isogram    
done

# check if if_empty_then_isogram is empty, then isogram :)
[[ -z $if_empty_then_isogram ]] && echo 'true' || echo 'false'
