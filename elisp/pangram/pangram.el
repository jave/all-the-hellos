;;; pangram.el --- Pangram (exercism)

;;; Commentary:

;;; Code:


(defun p-split (s)
  ;;splitting on "" returns a list like ("" "A" "B" ""). so i just delete "" and return the rest
  (-remove-item ""  (s-split "" s)))


(defun p-str-as-set (s)
  (-distinct (p-split (downcase s))))

(defun is-pangram (s)
  (not(-difference
       (p-str-as-set "abcdefghijklmnopqrstuvwxyz")
       (p-str-as-set s)
       ))
  )

(provide 'pangram)
;;; pangram.el ends here
