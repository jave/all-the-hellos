(ns proverb)

(defn recite [] ;; <- arglist goes here
    ;; your code goes here
)




"For want of a nail the shoe was lost."
"And all for the want of a nail."


(defn recite [instack]
  (if (not(empty? instack))
    (clojure.string/join "\n"  (loop [stack instack
                                      out []]

                                 

                                 (if (< 1 (count stack))
                                   (recur (rest stack)
                                          (conj out (format "For want of a %s the %s was lost." (first stack) (second stack)))
                                          )
                                   
                                   (conj out (format "And all for the want of a %s." (first instack)))
                                   )
                                 
                                 ))
    ""
    ))
 
;(recite  '("nail" "shoe" "horse" "mupp" "gurka"))
(recite '("nail"))
(recite '())

(seq '())
