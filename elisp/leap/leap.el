;;; leap.el --- Leap exercise (exercism)

;;; Commentary:

;;; Code:

;;my clojure solution

(defun divisiblep (y n)
  (zerop (mod y n)))

;;(divisiblep 400 100)
(unless nil )

;;this is not a thing of beauty
(defun leap-year-p (y)
  (if (not (divisiblep y 4))
      nil   ;; common year
    (if (not (divisiblep y 100))
        t ;; leap year
      (if (not (divisiblep y 400))
          nil;;common year

            t ;; leap year
            ))))
;; ;;(leap-year-p 2018)
;; ;;(leap-year-p 1996)
;;(leap-year-p 1997)

(provide 'leap)
;;; leap.el ends here
