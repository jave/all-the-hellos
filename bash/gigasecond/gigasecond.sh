#!/usr/bin/env bash

# date has date arithmetic!
# LC_ALL=us date --date="2011-04-25Z+1000000000 second" -u
# the tests assume us locale, so need to prefix date with LC_ALL=us

# this thing works but there is some formatting issue so the tests dont match

LC_ALL=us date --date="$@+1000000000 second" -u
