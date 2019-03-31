(ns prime-factors)

(defn of [nin]
  (loop [n nin
         i 2
         factors []]
    (if (> i n)
      factors
      (if (= 0 (mod n i))
        (recur (/ n i)
               i
               (conj factors i))
        (recur n
               (inc i)
               factors)))))

;;(of 60)

