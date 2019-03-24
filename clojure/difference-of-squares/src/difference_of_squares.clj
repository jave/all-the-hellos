(ns difference-of-squares)


(defn sum-of-squares [n] ;; <- arglist goes here
  ;; your code goes here
  (int (apply + (map #(Math/pow % 2) (range 1 (inc n)))))
)

(defn square-of-sum [n] ;; <- arglist goes here
  (int (Math/pow (apply + (range 1 (inc n))) 2))
)


;;(Math/pow (apply + (range 1 (inc 10))) 2)
;;3025.0

;;(apply + (map #(Math/pow % 2) (range 1 (inc 10))))
;;385.0

(defn difference [n] ;; <- arglist goes here
  ;; your code goes here
  (- (square-of-sum n) (sum-of-squares n))
)
