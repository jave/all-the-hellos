(ns leap)
;; on every year that is evenly divisible by 4
;;   except every year that is evenly divisible by 100
;;     unless the year is also evenly divisible by 400

;; if (year is not divisible by 4) then (it is a common year)
;; else if (year is not divisible by 100) then (it is a leap year)
;; else if (year is not divisible by 400) then (it is a common year)
;; else (it is a leap year)

(defn divisible? [y n]
  (zero? (mod y n)))

(defn leap-year? [y]
  (if-not (divisible? y 4)
           false ;; common year
           (if-not (divisible? y 100)
             true ;; leap year
             (if-not (divisible? y 400)
               false ;;common year
               true ;; leap year
               ))))
;;(leap-year? 2018)
;;(leap-year? 1996)
