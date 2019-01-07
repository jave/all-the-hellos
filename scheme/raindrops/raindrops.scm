(define-module (raindrops)
  #:export (convert))

(use-modules (srfi srfi-9))

(define-record-type <soundfactor>
  (make-soundfactor sound factor)
  soundfactor?
  (sound soundfactor-sound)
  (factor soundfactor-factor)
  )

(define soundfactors
  (list
   (make-soundfactor "Pling" 3)
   (make-soundfactor "Plang" 5)
   (make-soundfactor "Plong" 7)))


;;rather than a full factorization i can check divisability for 3,5,7. not sure what i feel like atm
;;then i wanted anaphoric macros but didnt figure out how to in guile
;; so i tried the record type
(define (divisable? x y)
  (eqv? 0 (modulo x y)))

(define (plong x)
  (string-join   (map (lambda (y)
         (if (divisable? x (soundfactor-factor y))
             (soundfactor-sound y)
             ""
             )) soundfactors  ) ""))

(define (convert x)
  (let ((plongstr (plong x)))
    (if (equal? "" plongstr) (number->string x) plongstr)
    )
  )


