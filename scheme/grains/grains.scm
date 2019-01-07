(define-module (grains)
  #:export (square total)
  #:autoload (srfi srfi-1) (iota))

(define (square n)
  (expt 2 (- n 1))
  )

;;(square 64)
(define (total)
  (let lp ((squarenum 1)
           (sum 0))
    (if (< squarenum 65)
        (lp (+ 1 squarenum)
            (+ sum (square squarenum)))
        sum)))

;;(total)
