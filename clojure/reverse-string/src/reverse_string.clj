(ns reverse-string
    (:use clojure.string))

(defn reverse-string [s] ;; <- arglist goes here
  ;; your code goes here
(join (clojure.core/reverse (split s #"")))  
)

;;(join (clojure.core/reverse (split "demo" #"")))
