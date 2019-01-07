(ns grade-school
  (:use clojure.algo.generic.functor))

;;this exercise was kind of lame, because you needed to implement a certain structure,
;;and maybe id like to use some other structure like a set or somesuch.

;;struct looks like: {3 ["Chelsea"] 7 ["Logan"]}
(defn add [db name grade]
    (assoc db grade (conj (vec (get db grade)) name))
  )

(defn grade [db grade]
  (vec (get db grade)))

;;the names should also be sorted. i used fmap
(defn sorted [db]
  (fmap sort (into (sorted-map) db)))










