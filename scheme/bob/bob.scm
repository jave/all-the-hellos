(define-module (bob)
  #:export (response-for))
 (use-modules (ice-9 regex))


(define (response-for s)
  (cond
   ((equal? "" (string-trim s)) "Fine. Be that way!")
   ((and (string-match "[a-zA-Z]" s)  (equal? s (string-upcase s)))              "Whoa, chill out!"  )
   ((string-suffix? "?" s) "Sure.")

   (else "Whatever.")))

