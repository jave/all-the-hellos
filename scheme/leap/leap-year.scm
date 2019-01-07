(define-module (leap-year)
  #:export (leap-year?))

;; function isLeapYear (year):
;;     if ((year modulo 4 is 0) and (year modulo 100 is not 0))
;;     or (year modulo 400 is 0)
;;         then true
;;     else false

(define (divisible? x y)
  (eq? 0(modulo x y)))


(define (leap-year? year)
  (or   (and (divisible? year 4) (not (divisible? year 100)))
        (divisible? year 400))

  )

;;          (leap-year? 2400)
