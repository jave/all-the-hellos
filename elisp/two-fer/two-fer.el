;;; hello-world.el --- Hello World Exercise (exercism)

;;; Commentary:

;;; Code:

(defun two-fer (&optional name)
  (format "One for %s, one for me." (or name "you")))

(provide 'hello-world)
;;; hello-world.el ends here
