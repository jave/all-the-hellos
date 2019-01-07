;;; roman-numerals.el --- roman-numerals Exercise (exercism)

;;; Commentary:

;;; Code:


(defun to-roman (n)
  (let (( roman-numerals
          '(
            ("M" . 1000)
            ("CM" . 900)
            ("D" .  500)
            ("CD" .  400)
            ("C" . 100)
            ("XC" . 90)
            ("L" . 50)
            ("XL" . 40)
            ("X" . 10)
            ("IX" . 9)
            ("V" . 5)
            ("IV" . 4)       
            ("I" . 1)
            ))
        ( result '()))
    (while roman-numerals
      (let ((current-roman-num (cdar roman-numerals))
            (current-roman-str (caar roman-numerals)))
        (if (<= 1(/ n current-roman-num))
            (progn
              (push   (-repeat (/ n current-roman-num)current-roman-str) result )
              (setq n (- n (* (/ n current-roman-num)current-roman-num))))
          ))
      
      (pop roman-numerals) ;; dont always popp
      )
    (s-join "" (-flatten(reverse result))))
  )


(provide 'roman-numerals)
;;; roman-numerals.el ends here
