;;; acronym.el --- Acronym (exercism)

;;; Commentary:

;;; Code:

(require 'cl)

(defun acronym (s)
  (apply 'concat (--map (upcase (s-left 1 it))   (split-string s "[^a-zA-Z]"))))


(provide 'acronym)
;;; acronym.el ends here
