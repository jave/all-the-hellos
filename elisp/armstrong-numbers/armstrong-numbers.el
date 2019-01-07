;;; armstrong-numbers.el --- armstrong-numbers Exercise (exercism)

;;; Commentary:

;;; Code:


(defun armstrong-p (n)
  (let* ((ns (number-to-string n )))
    (= n (apply #'+ (--map (math-pow (- it 48 ) (length ns) )(vconcat ns))))))

(provide 'armstrong-numbers)
;;; armstrong-numbers.el ends here
