(ns rotational-cipher)



(defn rotate-letter [letter key]
  (cond
    (contains? #{\ \. \0 \1 \2 \3 \4 \5 \6 \7 \8 \9 \! \, \'} letter) letter
    
    (>= (int letter) (int \a))
    (char (+ (int \a) (mod (+ key (- (int letter) (int \a))) 26)))    
    
    :else
    (char (+ (int \A) (mod (+ key (- (int letter) (int \A))) 26)))

)) 

;;(clojure.string/join (rotate "The Quick" 13))

;;(rotate-letter \  0)



(defn rotate [s key]
  (clojure.string/join (map #(rotate-letter % key) s))
  )



()
