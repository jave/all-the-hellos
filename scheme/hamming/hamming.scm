(define-module (hamming)
  #:export (hamming-distance))
(use-modules (ice-9 textual-ports))


(define (hamming-distance a b)
  (let ((la (string->list a))
        (lb (string->list b))
        (dist 0))
    (map (lambda (a b)
           (if (not (eq? a b )) (set! dist (+ 1 dist) )  ))
         la lb)
    dist))
