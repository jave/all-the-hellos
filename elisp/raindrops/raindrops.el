;;; raindrops.el --- Raindrops (exercism)

;;; Commentary:

;;; Code:

(require 'cl)



(defun convert-it (n)
  "Convert integer N to its raindrops string."
  (cond
   ((= n 3)  "Pling")
   ((= n 5)  "Plang")
   ((= n 7)  "Plong")
   (t "?")
 ))

;;the idea is to prime factor, uniqify, then keep only 3 5 7
;; then plingify. this way is more fun than the simpler aproach
(defun convert (n)
  (let ((f  (-intersection '(3 5 7) (-uniq (prime-factors n)))))
    (cond
     ((null f) (format "%s" n))
     (t (apply 'concat (--map (convert-it it) f)))
     ))
  )



;;from primes.el, which doesnt seem packaged anywhere anymore? whered it go?
(defun prime-factors (n)
  "Return a list of prime factors of N.
 
If N is prime, there are no factors, except the trivial one of N itself,
so the return value is the list (N).  Thus, if (length (prime-factors N))
is 1, N is prime.
 
Otherwise, if N is not an integer greater than 1, the return value is
nil, equivalent to an empty list.
 
\[cost: O(N)]"
  (interactive)
  (let ((result-list nil)
	(n-original n))
    (if (and (integerp n) (> n 1))
	(let ((limit (/ n 2))
	      (divisor 2))
	  (while (<= divisor limit)
	    ;; To correctly handle factors of multiplicity > 1, we must
	    ;; be careful to advance the divisor only when it is not a
	    ;; factor!  When n is replaced by n/divisor, we can reset
	    ;; limit, but only to n/2, not to n.  Consider
	    ;; (prime-factors 15): the first factor found is 3, which
	    ;; reduces n to 5, which will be the next prime factor
	    ;; found, but would be lost if we reset limit to 5/2 == 2.
	    ;;
	    ;; If this divisor is rejected, as long as it is greater
	    ;; than 2, and thus, odd, we can step it by 2, halving the
	    ;; number of loop iterations.
	    (if (= 0 (% n divisor))
		(setq n (/ n divisor)
		      limit n
		      result-list (append result-list (list divisor)))
	      (if (= divisor 2)
		  (setq divisor 3)
		(setq divisor (+ divisor 2)))))
	  ;; If we end the while loop with an empty result-list, then
	  ;; the input N was prime, so set result-list to a one-element
	  ;; list:
	  (if (null result-list)
	      (setq result-list (list n-original)))))
    result-list))
 

(provide 'raindrops)
;;; raindrops.el ends here

