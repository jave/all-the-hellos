(ns bob
  (:use clojure.string)
  )

(defn response-for [s] ;; <- arglist goes here
  ;; your code goes here
  (cond
    (and (re-find #"[ABCDEFGHIJKLMNOPQRSTUVXYZ]" s)
         (not (re-find #"[abcdefghijklmnopqrstuvxyz]" s)))
    "Whoa, chill out!"

    (ends-with? s "?")  "Sure."

    
    (= "" (trim s))  "Fine. Be that way!"
   :else "Whatever."

   )
  )
