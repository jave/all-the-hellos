#!/bin/sh

"exec" "clojure" "-Sdeps" '{:deps {clj-time {:mvn/version "0.14.2"}}}' "$0" "$@"

;; Clojure code goes here.
(println "hello! from https://clojure.org/guides/faq")
