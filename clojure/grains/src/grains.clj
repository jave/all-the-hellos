(ns grains
  (:require  [clojure.math.numeric-tower :as math])
  )

;;(math/expt 2N 64N) ;;from numeric-tower. use bigints

(defn square [x]
  (math/expt 2N (dec x)))

(defn total []
  (loop [acc 0 index 1]

    (if (> 65 index)
      (recur (+ acc (square index))
             (inc index)
             )
      acc)))
