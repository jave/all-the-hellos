;;; perfect-numbers.el --- perfect-numbers Exercise (exercism)

;;; Commentary:

;;; Code:


(defun divisable? (x y)
  (= 0 (% x y))
  )
;;(divisable? 4 3)

;;lame factorization attempt
;;recursion is no good in elisp sadly
(defun factorization-3 (x)
  (let ((n 1)
        (acc '()))
    (while (< n x)
      (if (divisable? x n) (setq acc (cons  n acc)) )
      (setq n (+ 1 n))
      
      )
    acc))

;;(factorization 6)
;;(factorization-2 7 2 '(1))

(defun factorization (x)
  ;;(factorization-2 x 2 '(1))
  (factorization-3 x))

;;(factorization 32)

(defun aliquot_sum (x)
  (apply '+ (factorization x)))
;;(aliquot_sum 32)

;;(factorization 12)
;;(aliquot_sum 12)
(defun classify (x)
  (cond
   ((> 0 x) (throw  (IllegalArgumentException. "bad")))
   ((> x (aliquot_sum x)) :deficient)
   ((< x (aliquot_sum x)) :abundant)
   ((= x (aliquot_sum x)) :perfect)
   )
  )

;;(classify 8)

(defun perfect-numbers (x)
  (let ((y 2)
        (res '()))
    (while (>= x y)
      
      (if (equal :perfect (classify y)) (push y res))
      (incf y)
      )
    (reverse res)
    )
  
  )

;;(perfect-numbers 6)
;;(factorization 6)
;(perfect-numbers 10000)
;;(setq max-specpdl-size 100000)



(provide 'perfect-numbers)
;;; perfect-numbers.el ends here
