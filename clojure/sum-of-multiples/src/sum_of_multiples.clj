(ns sum-of-multiples)

(defn sum-of-multiples [multiples n]
  (reduce + (loop
                [found []
                 i 1]
              (if (>= i n)
                found
                (recur (conj found  (if (>  (reduce +
                                                    (map #(if (= 0 (mod i %))
                                                            % 0) multiples  ))
                                            0) i 0))
                       (inc i)))
              ))
      
)

;;(sum-of-multiples [3 5 ] 20)
