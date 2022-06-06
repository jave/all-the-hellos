#!/bin/bash
#_ (

   #_DEPS is same format as deps.edn. Multiline is okay.
   DEPS='{:deps {clj-time {:mvn/version "0.14.2"}}}'

   #_You can put other options here
   #_OPTS='-J-Xms256m -J-Xmx256m -J-client'

   echo clojure $OPTS -Sdeps "$DEPS" "$0" "$@"
   #_exec clojure $OPTS -Sdeps "$DEPS" "$0" "$@"
   #_clojure -Sdeps "$DEPS" "$0" "$@"
    exec clojure ${OPTS} -Sdeps "{$DEPS}"  "$0" "$@"   

)

(println "Hello!")

(require '[clj-time.core :as t])
(prn (str (t/now)))
(prn *command-line-args*)
(println (.. (Runtime/getRuntime)
             totalMemory))
