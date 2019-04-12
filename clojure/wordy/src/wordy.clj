(ns wordy
    (:require [instaparse.core :as insta]))

;; writing parsers by hand is fun and all, but i prefer to play with
;; instaparse here

;; the instaparse docs even have an infix notation evaluator,
;; but "wordy" isnt proper infix so the final evaluator becomes a bit
;; convoluted

;; so this code isnt supposed to be an example of solving wordy, it
;; can be seen as a small instaparse example

(def wordy-parser
  (insta/parser
   "
<expr>  = begin <q> | begin statements  <q>
<begin> = <whatis> <ws> number <ws*>
<statement> =  op <ws> number <ws*>
<statements> = statement+
<op> = add | mul | div | sub
add = <'plus'>
mul = <'multiplied by'>
div = <'divided by'>
sub = < 'minus'>
<q> = '?'
number = #'-*[0-9]+'
<whatis> = \"What is\"
<ws> = #'\\s+'
"))

;; (insta/parse wordy-parser "What is 5?")
;; (insta/parse wordy-parser  "What is 7 minus 5 ?")

;; (->>
;;  (insta/parse wordy-parser "What is 3 plus 2 plus 3 multiplied by 5?")
;;  (insta/transform {
;;                    :number clojure.edn/read-string })
;;  )


(defn evaluate [s]
  (try 
    (let [expr1 (->>
                 (insta/parse wordy-parser s)
                 (insta/transform {
                                   :number clojure.edn/read-string }))]
      (loop [
             acc (first expr1)
             expr (rest expr1)
             ]
        (cond (empty? expr) acc 

              :else
              (recur (apply (get {[:add] + [:sub] - [:mul] * [:div] /} (first expr))
                            (list acc (second expr)))
                     (rest (rest expr))))))
    (catch Exception e (throw (IllegalArgumentException. "bad")))))





