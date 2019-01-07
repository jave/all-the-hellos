
(defn flatten2 [in out]
  (cond
    (empty? in) out
    (coll? (first in)) (recur (first in) out)
    (not(coll? (first in)))  (recur (rest in) (conj out (first in)))
    :else :wtf
    ))

;;(flatten2 '(a (b(d e f) c g)) '())

;;(flatten2 '(1 (2 ((3)) (4 ((5))) 6 7) 8) '())

;;           (flatten2 [1 [2 [[3]] [4 [[5]]] 6 7] 8] '())

;;recursion playground

;;faculty 
(defn factorial [x]
  (if (= 1 x) 1
      (* x (factorial (dec x) ))))
;;(factorial 4)

;;tail call optimized
(defn factorial2
  ([x] (factorial2 x 1))
  ([x acc]
   (if (= 1 x) acc
       (recur (dec x) (* x acc)))))


;;(factorial2 4)

(defn listrecur [l]
  (if (symbol? (first l))
    (do    (first l)
           (println (first l)))
    (do
      (println (first l))
      (listrecur (first l))))
  (if (symbol? (first (rest l)))
    (do
      (println (first (rest l)))
      (first (rest l)))
    (do
      (println (first (rest l)))
      (listrecur (first (rest l)))))

  ;;
  )

;;(listrecur '(a (b(d e f) c g)))


(defn tst [l]
  (cond
    (symbol? l)  l
    (empty? l) :end
    :else
    (list (tst (first l)) (tst (rest l))))

  )
;;(tst '(a b))

;;this version seems to work
(defn flatten [l]
  (cond (empty? l) ()
        (not (coll? (first l))) (cons (first l) (flatten (rest l)))
        :else (concat (flatten (first l)) (flatten (rest l)))
        )
  )

;(flatten '(a (b) c ((d e))))
;(flatten '[a b [c [d e]] f])
;(flatten '((a) (b)))

;; (defun flatten (l)
;;   (cond ((null l) nil)
;;         ((atom (car l)) (cons (car l) (flatten (cdr l))))
;;         (t (append (flatten (car l)) (flatten (cdr l))))))

