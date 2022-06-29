(defpackage :larrys-winning-checker
  (:use :cl)
  (:export
   :make-empty-board
   :make-board-from-list
   :all-the-same-p
   :row
   :column))

(in-package :larrys-winning-checker)


(defconstant *board-rows* 3)
(defconstant *board-cols* 3)

(defun make-empty-board ()
  (make-array (list *board-rows* *board-cols*)
              :initial-element nil))

(defun make-board-from-list (list)
  (make-array (list *board-rows* *board-cols*)
              :initial-contents list))

;;use "reduce" to check if all elements are the same
;; perhaps apply = would also work
(defun all-the-same-p (row-or-column)
  (reduce (lambda (a b)
            (if (eq a b) b (return-from all-the-same-p nil)))
          row-or-column))

;; ... or you can just hard code
(defun row (board row-num)
   (vector
    (aref board row-num 0)
    (aref board row-num 1)
    (aref board row-num 2)))

(defun column (board col-num)
  (vector
   (aref board 0 col-num)
   (aref board 1 col-num)
   (aref board 2 col-num)))
