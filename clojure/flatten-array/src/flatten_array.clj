(ns flatten-array)

;;of course, the clojure "flatten" functioni already does this.
;; so the idea is to reimplement flatten here.

;;maybe a recursive function
(defn flatten [l]
  (cond
    (empty? l) ()
    (not (or (nil? (first l)) (coll? (first l)))) (cons (first l) (flatten (rest l)))
    :else (concat (flatten (first l)) (flatten (rest l)))
    )
  )

;; one could rewrite using recur for efficiency

;;(flatten '(nil))
;;(flatten-array/flatten [nil [[[nil]]] nil nil [[nil nil] nil] nil])

;;(flatten '(a (b) c ((d e))))
;;(flatten '[a b [c [d e]] f])
;;(flatten '((a) (b)))

