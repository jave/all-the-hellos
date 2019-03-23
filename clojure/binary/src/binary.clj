(ns binary)

(defn to-decimal [s]
  (apply + (map-indexed #(* (int (Math/pow 2 %1))  (max 0 (Character/digit %2 10))) (reverse s)))  
  
)


;; (clojure.math.numeric-tower/expt 2 200)
;; (clojure.contrib.math/expt 2 200)
;; (Math/pow 2 200)

;;(int 8.0)

;;(Character/digit \2 10)
;;(max -1 0)
