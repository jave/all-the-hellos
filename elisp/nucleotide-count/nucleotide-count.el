;;; nucleotide-count.el --- nucleotide-count Exercise (exercism)

;;; Commentary:

;;; Code:

;;(nucleotide-count "AGCTTTTCATTCTGACTGCAACGGGCAATATGTCTCTGTGTGGATTAAAAAAAGAGTGTCTGATAGCAGC")



(defun nucleotide-count (s)

  (let ((rv '((?A . 0) (?C . 0) (?G . 0) (?T . 0))))
    (mapc
     (lambda (k)
       (if (not(memq k '(?A ?C ?G ?T))) (throw :exception "alien nucleotide") )
       (setq rv (a-update rv k (lambda (x) (+ 1 (if (null x) 0 x))))))
     (string-to-vector s)
     )
    rv )
  

  )

;;(nucleotide-count "AG")
(provide 'nucleotide-count)
;;; nucleotide-count.el ends here
