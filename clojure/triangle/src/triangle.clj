(ns triangle)

(defn type [a b c] ;; <- arglist goes here
  ;; your code goes here
  (let [setcount (count(set (list a b c)))
        sorted  (sort (list a b c))]
    (cond
      (<= (+ (first sorted) (second sorted)) (nth sorted 2)) :illogical
      (= 1 setcount) :equilateral
      (= 2 setcount) :isosceles
      (= 3 setcount) :scalene
      
      ))
      )
;;(type 1 2 1)
