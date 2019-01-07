;;; binary.el --- Binary exercise (exercism)

;;; Commentary:

;;; Code:

;;this same fn comes up all the time in the exercises, i should try someme variations on it
(defun b-split (s)
  (-remove-item ""  (s-split "" s)))

(defun to-decimal (s)
  (condition-case nil 
      (apply '+ (--map-indexed (* (read it) (expt 2 it-index)) (reverse (b-split s))))
    (error 0)) ;;return 0 according to specs if error
  )
;;(to-decimal "0110")

(provide 'binary)
;;; binary.el ends here
