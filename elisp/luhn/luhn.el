;;; luhn.el --- Luhn exercise (exercism)

;;; Commentary:

;;; requires, work around since we cant install pkg:s in the exercism testrunner
(defmacro --each (list &rest body)
  "Evaluate BODY for each element of LIST and return nil.
Each element of LIST in turn is bound to `it' and its index
within LIST to `it-index' before evaluating BODY.
This is the anaphoric counterpart to `-each'."
  (declare (debug (form body)) (indent 1))
  (let ((l (make-symbol "list"))
        (i (make-symbol "i")))
    `(let ((,l ,list)
           (,i 0)
           it it-index)
       (ignore it it-index)
       (while ,l
         (setq it (pop ,l) it-index ,i ,i (1+ ,i))
         ,@body))))

(defmacro --map (form list)
  "Eval FORM for each item in LIST and return the list of results.
Each element of LIST in turn is bound to `it' before evaluating
FORM.
This is the anaphoric counterpart to `-map'."
  (declare (debug (def-form form)))
  `(mapcar (lambda (it) (ignore it) ,form) ,list))

(defmacro --map-indexed (form list)
  "Eval FORM for each item in LIST and return the list of results.
Each element of LIST in turn is bound to `it' and its index
within LIST to `it-index' before evaluating FORM.  This is like
`--map', but additionally makes `it-index' available to FORM.

This is the anaphoric counterpart to `-map-indexed'."
  (declare (debug (form form)))
  (let ((r (make-symbol "result")))
    `(let (,r)
       (--each ,list
         (push ,form ,r))
       (nreverse ,r))))

(defun -reduce (fn list)
  "Reduce the function FN across LIST.
Return the result of applying FN to the first two elements of
LIST, then applying FN to that result and the third element, etc.
If LIST contains a single element, return it without calling FN.
If LIST is empty, return the result of calling FN with no
arguments.

This function's anaphoric counterpart is `--reduce'.

For other folds, see also `-reduce-from' and `-reduce-r'."
  (if list
      (-reduce-from fn (car list) (cdr list))
    (funcall fn)))

(defun -reduce-from (fn init list)
  "Reduce the function FN across LIST, starting with INIT.
Return the result of applying FN to INIT and the first element of
LIST, then applying FN to that result and the second element,
etc.  If LIST is empty, return INIT without calling FN.

This function's anaphoric counterpart is `--reduce-from'.

For other folds, see also `-reduce' and `-reduce-r'."
  (--reduce-from (funcall fn acc it) init list))

(defmacro --reduce-from (form init list)
  "Accumulate a value by evaluating FORM across LIST.
This macro is like `--each' (which see), but it additionally
provides an accumulator variable `acc' which it successively
binds to the result of evaluating FORM for the current LIST
element before processing the next element.  For the first
element, `acc' is initialized with the result of evaluating INIT.
The return value is the resulting value of `acc'.  If LIST is
empty, FORM is not evaluated, and the return value is the result
of INIT.
This is the anaphoric counterpart to `-reduce-from'."
  (declare (debug (form form form)))
  `(let ((acc ,init))
     (--each ,list (setq acc ,form))
     acc))


;;; Code:

(defun luhn-p (pnr)
  (let ((pnr-clean (replace-regexp-in-string " " "" pnr)))
    (cond
     ((equal "0" pnr-clean) nil)
     ((equal "" pnr-clean) nil)
     ((string-match "[^0-9]" pnr-clean )  (error "non number found"))
     (t
      (equal 0 (mod  
                (-reduce #'+ 
                         (--map (if (> it 9) (- it 9) it) 
                                (reverse (--map-indexed
                                          (* (if (= 0 (mod it-index 2))
                                                 1
                                               2)
                                             it
                                             ;;(-  it 48)
                                             )
                                          (reverse
                                           (mapcar #'string-to-number (split-string
                                                                       pnr-clean
                                                                       "" t))
                                           )))))
                10
                )))))
  )


(provide 'luhn)
;;; luhn.el ends here

(--map-indexed (list it it-index) (--map (list it) "abc"))

(mapcar #'string-to-number (split-string  "123" "" t))

(string-to-number "0")
(string-match "[^0-9]" "12234a")
