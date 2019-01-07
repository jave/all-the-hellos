;;; hello-world.el --- Hello World Exercise (exercism)

;;; Commentary:

;;; Code:


(provide 'hello-world)
(defun hello (&optional name)
  
  (format "Hello, %s!" (or name "World")) )
;;(hello "test")
;;(hello)
;;; hello-world.el ends here
