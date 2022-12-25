(ns largest-series-product)

(defn largest-product [window-length number-string] ;; <- arglist goes here
  ;; your code goes here
  (cond
    (= 0 window-length) 1
    (not (= number-string (clojure.string/replace number-string #"[a-z]" ""))) (throw (Exception. "bad chars in string")) 
    :else
        (apply max (map #(apply * %) (partition window-length 1 (map #(Character/digit % 10) number-string)))))
)

;;solution idea:
;; (apply max (map #(apply * %) (partition 4 1 (map #(Character/digit % 10) "1234567890"))))
;; - convert every character in the string to a number
;; - use partition to slide over the list of numbers, generating sub lists
;; - on each sub list, apply *
;; - on the resulting list, do max
;; - done!


;; apart from this, some input checking and whatnot
;; (Character/digit \a 10)
;; (clojure.string/replace "ab123x"  #"[a-z]" "")
