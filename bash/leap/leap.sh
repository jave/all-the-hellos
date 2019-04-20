#!/usr/bin/env bash

# this is the rule:
# on every year that is evenly divisible by 4
#   except every year that is evenly divisible by 100
#     unless the year is also evenly divisible by 400

year=$1

if [[ $# != 1 ]] || ! [[ $year =~ ^[0-9]+$  ]] ; then
    echo "Usage: leap.sh <year>"
    exit 1
fi



if [[ $(( $year % 4 )) == 0 ]] && !  [[ $(($year % 100 )) == 0 ]]  ||  [[ $(($year % 400 )) == 0 ]] ; then
    echo true
else
    echo false
fi
