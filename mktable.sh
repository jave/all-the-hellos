# langs to do the table for
#langs="clojure bash python racket go groovy scheme elisp"
langs="clojure
c
bash
common-lisp
cpp
elisp
go
groovy
haskell
java
julia
kotlin
lfe
lua
mips
ocaml
prolog
python
r
racket
rust
scala
scheme
javascript
wasm
"
cd ~/pub/all-the-hellos/
# all the exercises in all the langs, uniqifed, also remove lang dir name with sed
# bug: files are also added
exercises=$(ls $langs|sed s/.*:$//g|sort|uniq)

#echo $exercises
#for each lang do something
for exercise in $exercises; do
    #    echo -n "exercise: $exercise : "
#    echo -n "exercise: $exercise : "
    printf "%22s : " "$exercise"
    for lang in $langs; do
        l=$(ls $lang|grep $exercise)
        if [[ ! $l == ""  ]] ; then
            #echo -n "$lang "
            printf "%3s:" "${lang:0:3}"
        else
            printf "%3s:" "   "
        fi
    done
    echo    
done    


# if you want to sort on line length
# ./mktable.sh|  perl -e 'print sort { length($a) <=> length($b) } <>'
