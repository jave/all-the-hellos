(define-module (dna)
  #:export (to-rna))

(define (rna c)
  (case c
    ((#\C) #\G)
    ((#\G) #\C)
    ((#\A) #\U)
    ((#\T) #\A)
    )
  )


(define (to-rna dna)
  (list->string(map rna (string->list dna))))


