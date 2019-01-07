;;; allergies.el --- Allergies Exercise (exercism)

;;; Commentary:

;;; Code:

(setq allergies
      '(
        (1 "eggs") 
        (2 "peanuts") 
        (4 "shellfish") 
        (8 "strawberries") 
        (16 "tomatoes") 
        (32 "chocolate")
        (64 "pollen") 
        (128 "cats")))

(defun matchingstuff (a)
  (remove 0
          (loop for x from 0 to 8
                for y = (lsh 1 x)
                collect (logand a  y))))

(defun allergen-list (a)
  (remove nil (--map  (cadr(assoc it allergies))   (matchingstuff a))))

(defun allergic-to-p (x y)
  (-contains? (allergen-list x) y))

(provide 'allergies)
;;; allergies.el ends here
