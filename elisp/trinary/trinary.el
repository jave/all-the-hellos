;;; trinary.el --- Trinary (exercism)

;;; Commentary:

;;; Code:



(require 'cl-lib)

(defun b-split (s)
  (-remove-item ""  (s-split "" s)))

(defun to-decimal (s)
  (condition-case nil 
      (apply '+ (--map-indexed (* (read it) (expt 3 it-index)) (reverse (b-split s))))
    (error 0)) ;;return 0 according to specs if error
  )
;;(to-decimal "102012")



(provide 'trinary)
;;; trinary.el ends here
