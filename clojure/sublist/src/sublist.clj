(ns sublist)

(defn is-a-in-b-at-i? [a b i]
  "is a in b at index i?"
  (= a (subvec b i (+ i (count a)))))

(defn is-a-in-b? [a b]
  "is a in b?"
  (loop [i 0
         acc nil]
    (if (<= i (- (count b)
                 (count a)))
      (recur (inc i)
             (conj acc (is-a-in-b-at-i? a b i)))
      acc)
      )
    )


;;could be refactored a bit
(defn classify [a b]
  "return :equal, :unequal, :sublist, or :superlist"
  (cond (= a b) :equal
        (and (> (count b) (count a)) (reduce #(or %1 %2) (is-a-in-b? a b))) :sublist
        (and (> (count a) (count b)) (reduce #(or %1 %2) (is-a-in-b? b a))) :superlist
        :else :unequal
          ))
