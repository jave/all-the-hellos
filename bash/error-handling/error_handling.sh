#!/usr/bin/env bash
set -o errexit
set -o nounset

# check we have at least one argument, otherwise print usage
if [ $# -ne 1 ] ; then
    echo "Usage: ./error_handling <greetee>"
    exit 1
else
    # we have an arg, print it
    echo "Hello, $1"
    exit 0
fi
