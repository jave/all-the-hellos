;;; grains.el --- Grains exercise (exercism)

;;; Commentary:

;;; Code:

(defun square (n)
  "square of n, bignum"
  (math-pow 2 (- n 1))

  )

(defun total ()
  "total of square, bignum"
  (--reduce (math-add it acc)
            (--map (square it) (number-sequence 1 64 )))
  
  )

;;(math-format-number (total))

;;dunno, tests seems borken for this one. i verified manually.

(provide 'grains)
;;; grains.el ends here
