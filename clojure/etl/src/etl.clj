(ns etl)

;;reduce twice, 1st time over the tuples, 2nd time over the list in the 2nd part of the tuple
;; use merge to bind the 2 reduce parts together
;; (transform {1 ["APPLE" "ARTICHOKE"], 2 ["BOAT" "BALLERINA"]})
;;{"apple" 1 "artichoke" 1 "boat" 2 "ballerina" 2}

(defn transform [input]
  (reduce
   (fn [new-col [itemnum items]]
     (merge new-col
           (reduce (fn [inneritems item]
                     (assoc inneritems (clojure.string/lower-case item) itemnum))
                   {}
                   items)))
   {}
     
   input))


