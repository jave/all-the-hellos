;;; robot-name.el --- Robot Name (exercism)

;;; Commentary:
;;
;; Build a robot with a name like AA000, that can be reset
;; to a new name. Instructions are in README.md
;;

;;; Code:

;;i choose a eieio variant solution for this

(defclass build-robot ()
  ((name :initarg :name
         :type string
         ))
  )

(defun mk-robot-name ()
(format "%s%03d" (string (+ 65 (random 26)) (+ 65 (random 26))) (random 1000))
  )

(defun robot-name (r) (oref r :name))

(defmethod initialize-instance :after ((obj build-robot) &rest args)
  (oset obj name (mk-robot-name))
  )

(oref (build-robot) :name)
(robot-name (build-robot))

(defun reset-robot (r)
  (oset r :name (mk-robot-name)))

(provide 'robot-name)
;;; robot-name.el ends here
