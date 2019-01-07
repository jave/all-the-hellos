;;; atbash-cipher.el --- Atbash-Cipher (exercism)

;;; Commentary:




;;; Code:

(defun encode-char (x)
  (if (and (< x 57)(> x 48))
      x
    (elt  (reverse(vconcat "abcdefghijklmnopqrstuvwxyz")) (- x 97))))


(defun encode-2 (plaintext)
  "Encode PLAINTEXT to atbash-cipher encoding."
  (concat(--map (encode-char it)
                (vconcat (replace-regexp-in-string "[ \\.,]" ""  (downcase plaintext)))))
  )

(defun encode (plaintext)
  ;;i wanted to play with the loop macro, but i guess it didnt turn out well
  (s-trim (let ((s (s-pad-right 100 " " (encode-2 plaintext)))
                (acc))
            (loop for i from 0 to (- (length s) 5) by 5
                  do (setq acc (concat acc (substring s i (+ 5 i)) " ")))
            acc)))


(provide 'atbash-cipher)
;;; atbash-cipher.el ends here
