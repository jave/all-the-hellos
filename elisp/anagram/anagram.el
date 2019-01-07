;;; anagram.el --- Anagram (exercism)

;;; Commentary:

;;; Code:

(require 'cl)

;;kind of like the pangram exercise.

(defun a-split (s)
  (-remove-item ""  (s-split "" s)))


;; this wont work, compare sorted lists instead
(defun a-str-as-set (s)
  (-sort 's-less? (a-split (downcase s))))

(defun a-similar (s1 s2)
  (and (= (length s1) (length s2)) 
       (not(equal
            (a-str-as-set s1)
            (a-str-as-set s2)
            )))
  )
;(equal (a-str-as-set "galea")
;             (a-str-as-set "eagle"))

;;(a-similar "abc" "bca")

(defun anagrams-for (s agramlist)
  (--map  (a-similar s it)  agramlist)
  
  )

(provide 'anagram)
;;; anagram.el ends here
