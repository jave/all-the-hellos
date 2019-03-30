(ns luhn
  (:require [clojure.string :as str])
  )

(defn valid? [pnr]
  (cond
    (= "0" (str/replace pnr " " "")) false
    :else
    (= 0 (mod  
          (reduce + 
                  (map #(if (> % 9) (- % 9) %)
                       (reverse (map-indexed #(* (if (= 0 (mod %1 2))
                                                   1
                                                   2)
                                                 
                                                 (- (int %2) 48) )
                                             (reverse (str/replace
                                                       ;;"4539 1488 0343 6467"
                                                       pnr " " ""))))))
          10
          )))
  )






