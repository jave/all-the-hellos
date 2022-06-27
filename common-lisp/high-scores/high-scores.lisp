(defpackage :high-scores
  (:use :cl)
  (:export :make-high-scores-table :add-player
           :set-score :get-score :remove-player))

(in-package :high-scores)

;; Define make-high-scores-table function
(defun make-high-scores-table () (make-hash-table))

;; Define add-player function
(defun add-player (h p)
  (setf (gethash p h) 0))
;; Define set-score function
(defun set-score (h p n)
  (setf (gethash p h) n))
;; Define get-score function
(defun get-score (h p)
  (gethash p h 0))
;; Define remove-player function
(defun remove-player (h p)
  (remhash p h))
