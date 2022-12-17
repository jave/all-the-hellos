(ns interest-is-interesting)

(defn interest-rate
  "TODO: add docstring"
  [balance]
  (condp > balance
    0.0 -3.213
    1000.0 0.5
    5000.0 1.621
    2.475
    
      )
  )
(defn abs [n] (max n (- n)))
;; (defn annual-balance-update
;;   "TODO: add docstring"
;;   [balance]
;;   (bigdec (* balance
;;              (+ 1M (* (bigdec (interest-rate (abs balance)))
;;                      0.01M))))
;;   )

(defn annual-balance-update
  [balance]
  (+
   (* (bigdec (interest-rate balance)) 0.01M (abs balance))
   balance))


(defn amount-to-donate
  "TODO: add docstring"
  [balance tax-free-percentage]
  (if (< 0 balance)
    (int (* balance 2 (* tax-free-percentage 0.01)))
    0)
  )


