(ns pascals-triangle
  (:require [tupelo.core :as t])
  )
;;(t/refer-tupelo)

;; 

(def triangle [[1], [1 1], [1 2 1]])

(defn row [r]

  (nth 
   (loop [rowcount 1
          triangle [[1]]]

     (if (= r rowcount)
       triangle
       (recur (inc rowcount)
              (conj triangle
                    (into [](map +' (t/prepend 0 (last triangle))  (t/append (last triangle) 0) )))))

     )
   (dec r))  
  )

(row 300)

;; try https://github.com/cloojure/tupelo#adding-values-to-the-beginning-or-end-of-a-sequence
;; for prepend append instead


