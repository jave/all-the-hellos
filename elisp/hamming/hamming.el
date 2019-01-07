;;; hamming.el --- Hamming (exercism)

;;; Commentary:

;;; Code:
(require 'dash)
(require 's)

(defun h-split (s)
  ;;splitting on "" returns a list like ("" "A" "B" ""). so i just delete "" and return the rest
  ;;turns out i didnt need this fn
  (-remove-item ""  (s-split "" s)))

(defun hamming-distance (a b)
  ;;mapcar* over the strings, check if each pos is the same as the same pos in the other string
  ;;count the number of nil:s in the result list, this count is the hamming distance
  (if (not (= (length a) (length b)))
      (throw "lengths not same"))
  (-count 'not (mapcar* #'equal a b))
  )
;;(hamming-distance "AG" "CT")
;;(mapcar* #'equal "ABC" "ADE")

;(hamming-distance "ABC" "ABD")
;(ert "^hamming-") ;; no theres no package prefix for the tests
(provide 'hamming)
;;; hamming.el ends here
