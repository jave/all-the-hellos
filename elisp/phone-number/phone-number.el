;;; phone-number.el --- phone-number Exercise (exercism)

;;; Commentary:

;;; Code:

(s-replace "[^0-9]*" "" "(123) 456-7890")
(replace-regexp-in-string "[^0-9]*" "" "(123) 456-7890" )

(defun numbers (n)
  (let* ((rv 
          (replace-regexp-in-string "[^0-9]*" "" n)))
    (cond
     ( (and (equal "1" (substring rv 0 1 ))  (=  (length rv) 11)) rv)
     ((>  (length rv) 10) "0000000000")
     ((<= (length rv) 9) "0000000000")
     (t rv))))

(defun area-code (n)
  (substring (numbers n) 0 3)
  )

(defun pprint (n)
  (let*
      ((n  (if (and (equal "1" (substring n 0 1 ))  (=  (length n) 11))
               (substring (numbers n) 1 11 )
             (numbers n)) ))
    (format "(%s) %s-%s" (area-code n) (substring n 3 6)  (substring n 6 10)))

  )

;;numbers
;;area-code
;;pprint
(provide 'phone-number)
;;; phone-number.el ends here
