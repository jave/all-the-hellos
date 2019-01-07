;;; rna-transcription.el -- RNA Transcription (exercism)

;;; Commentary:



;;; Code:
(defun transcribe-single (s)
  (pcase s
    ("G" "C")
    ("C" "G")
    ("A" "U")
    ("T" "A")
    (_ (error "Unknown input")))
  )

(defun to-rna (s)
  (apply 's-concat (--map (transcribe-single (string it)) (vconcat s))))

(provide 'rna-transcription)
;;; rna-transcription.el ends here
