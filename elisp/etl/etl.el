;;; etl.el --- etl Exercise (exercism)

;;; Commentary:

;;; Code:

;; mixed-case-input

(defun etl (input)
  (let 
      ((rv (make-hash-table )))
    (maphash (lambda (k1 v)
               (if (> 0 k1) (throw :error "negative"))
               (mapc (lambda (k2)
                       (if (not (stringp k2)) (throw :error "not string"))
                       (puthash (downcase k2) k1 rv)  ) v) )
             input)
    rv))

;;(pp(etl mixed-case-input))
(provide 'etl)
;;; etl.el ends here
