;;; difference-of-squares.el --- Difference of Squares (exercism)

;;; Commentary:

;;; Code:
(defun square-of-sums (n)
  (expt (apply '+ (number-sequence 1 n)) 2)
  )
;;(sum-of-n-squares 10)
(defun sum-of-squares (n)
  (apply '+ (mapcar (lambda (x) (expt x 2)) (number-sequence 1 n))))

(defun difference (n)
  (- (square-of-sums n) (sum-of-squares n))
  )

(provide 'difference-of-squares)
;;; difference-of-squares.el ends here
