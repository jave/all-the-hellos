(ns nth-prime)


;; a nth prime algorithm:

;; Iterate through only odd values, incrementing by 2
;; Divide each value by 2 < divisor  < √value
;; where divisor is only any one of the primes computed thus far.

;;  - only odd numbers can be primes (because even values are divisable by 2)
;;  - any number can be written as a factor of primes
;;  - theres no point going past √value 

;;this is slightly more optimized than the super simple approach of
;;trying all numbers less than the number under consideration

;; JAVE
;; sundaram, maybe? https://iq.opengenus.org/sieve-of-sundaram/

;; (defn nth-prime [n]
;;   ;; outer loop from 2 to n
;;   (loop [i1 2
;;          primes []]

;;     ;; inner loop checks current index if prime
;;     (loop []

;;       (recur)
;;       )
    
    
;;     (recur )
;;     )
;;   )


        

          


        

          

(defn prime? [n]
  (->> (range 2 (Math/sqrt (inc n)))
       (map #(mod n %))
       (every? pos?)))

          

(defn nth-prime [n]
  (when (zero? n) (throw (IllegalArgumentException. )))
  (nth (filter prime? (iterate inc 2)) (dec n)))
