
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

function mktable {

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

}


if [ $# == 0 ]
then
    mktable
elif [ $1 == "mktable" ]
then
    mktable
elif [ $1 == "test" ] || [ $1 == "submit" ]
then
    readarray -d / -t strarr <<< $(pwd|xargs)
    
    type=${strarr[5]}
    codebasename=$(echo ${strarr[6]}|xargs) #remove trailing newline which is there for some reason
    case $type in
        common-lisp)
            codefile=${codebasename}.lisp
            testfile=${codebasename}-test.lisp
            if [ $1 == "test" ]
            then
                sbcl --load $testfile --eval "(progn (${codebasename}-test:run-tests) (quit))"
            elif [ $1 == "submit" ]
            then
                exercism submit $codefile
            fi
            ;;
        clojure)
            codefile=src/${codebasename/-/_}.clj
            if [ $1 == "test" ]
            then
                lein test
            elif [ $1 == "submit" ]
            then
                exercism submit $codefile
            fi
            ;;
        go)
            codefile=${codebasename//-/_}.go
            if [ $1 == "test" ]
            then
                # https://stackoverflow.com/questions/67306638/go-test-results-in-go-cannot-find-main-module-but-found-git-config-in-users
                export GO111MODULE=auto
                go test
            elif [ $1 == "submit" ]
            then
                exercism submit $codefile
            elif [ $1 == "repl" ]
            then
                # go install github.com/x-motemen/gore/cmd/gore@latest
                gore
            fi
            ;;
        julia)
            codefile=$codebasename.jl
            if [ $1 == "test" ]
            then
                julia runtests.jl
            elif [ $1 == "submit" ]
            then
                exercism submit $codefile
            elif [ $1 == "repl" ]
            then
                julia
            fi
            ;;
        java)
            #codefile=${codebasename/-/_}.clj
            if [ $1 == "test" ]
            then
                /opt/gradle-7.0/bin/gradle test
            elif [ $1 == "submit" ]
            then
                #exercism submit $codefile
                #echo hmm
                codefile=$(find src/main/java -type f)
                exercism submit $codefile
                
            fi
            ;;
        wasm)
            codefile=${codebasename}.wat
            if [ $1 == "test" ]
            then
                npm test
            elif [ $1 == "submit" ]
            then
                exercism submit $codefile
                #echo hmm
                #codefile=$(find src/main/java -type f)
                #exercism submit $codefile
                
            fi
            ;;
        perl5)
            codefile=${codebasename}.pm
            if [ $1 == "test" ]
            then
                prove .
            elif [ $1 == "submit" ]
            then
                exercism submit $codefile
                #echo hmm
                #codefile=$(find src/main/java -type f)
                #exercism submit $codefile
                
            fi
            ;;
        clojurescript)
            codefile=${codebasename}.pm
            if [ $1 == "test" ]
            then
                clojure -A:test
            elif [ $1 == "submit" ]
            then
                codefile=$(find src -type f)
                exercism submit $codefile
                #echo hmm
                #codefile=$(find src/main/java -type f)
                #exercism submit $codefile
                
            fi
            ;;

    esac
    
fi

#sbcl --load key-comparison-test.lisp --eval "(progn (key-comparison-test:run-tests) (quit))" 
