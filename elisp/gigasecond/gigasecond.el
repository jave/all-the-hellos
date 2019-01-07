;;; gigasecond.el --- Gigasecond exercise (exercism)
(require 'dash)
;;; Commentary:
;; Calculate the date one gigasecond (10^9 seconds) from the
;; given date.
;;
;; NB: Pay attention to  Emacs' handling of time zones and dst
;; in the encode-time and decode-time functions.

;;; Code:

;;zone "t" is utc
;;(ert t)
(defun from (a b c d e f)
  (-take 6 (decode-time (time-add (encode-time a b c d e f t)
                                  (expt 10 9))
                        t))
  )

;;(from 0 0 0 1 1 1900)
;;   (equal '(40 46 1 9 9 2001) (from 0 0 0 1 1 1970))
(provide 'gigasecond)
;;; gigasecond.el ends here
