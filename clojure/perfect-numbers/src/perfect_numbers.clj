(ns perfect-numbers
  )

(defn divisable? [x y]
  (= 0 (mod x y))
  )

;;lame factorization attempt
(defn factorization [x]
  (loop [n 2
         acc [1]]
    (if (< n x)
      (recur (+ 1 n)
             (if (divisable? x n) (conj acc n) acc))
        acc)))
(defn aliquot_sum [x]
  (apply + (factorization x)))

;(factorization 12)
                                        ;(aliquot_sum 12)
(defn classify [x]
  (cond
    (> 0 x) (throw  (IllegalArgumentException. "bad"))
    (> x (aliquot_sum x)) :deficient
    (< x (aliquot_sum x)) :abundant
    (= x (aliquot_sum x)) :perfect
    )
          )
