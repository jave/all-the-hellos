;;; bob.el --- Bob exercise (exercism)
(require 's)
;;; Commentary:

;;; Code:
(defun  response-for (str)
  (cond  ((s-equals? (s-trim str) "")  "Fine. Be that way!")
         ;;((s-uppercase? str) "Whoa, chill out!")
         ((string-match-p "[[:upper:]]" str) "Whoa, chill out!")
         ((s-suffix? "?" str) "Sure.")
         
         (t "Whatever.")
        )
    )

;;(response-for "uh?")
;;(response-for "1, 2 3 ARGH?")
;;(response-for "1, 2 3")
;;(response-for "  ")



(provide 'bob)
;;; bob.el ends here
