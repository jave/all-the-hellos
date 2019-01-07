;;; word-count.el --- word-count Exercise (exercism)

;;; Commentary:

;;; Code:

;;(split-string "a b c d e g;h" "[^a-z]" t)
;; digits are ok
;; upcase locase the same
(defun word-count (in1)
  (let ((in (split-string in1 "[^a-z0-9]" t))
        out)
    (mapc
     (lambda (curword)
       (setq out (a-update out
                           (downcase curword)
                           (lambda (x) (+ 1 (if (null x) 0 x))))))
     in)
    out))

;;(word-count "one fish two fish red fish blue fish")
(provide 'word-count)
;;; word-count.el ends here
