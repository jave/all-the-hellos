(ns series
  (:use clojure.string))

(defn slices [string n]

  (if (zero? n) [""]
  (let [s1 string
        ]
    (loop [ i 0
           acc []]
      (if (>= (- (count s1) n) i)
        (recur (inc i)
               (conj acc (subs s1 i (+ i n))))
        acc)  ))

  ))


;; (slices "12345" 3)
