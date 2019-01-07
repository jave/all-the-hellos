(ns collatz-conjecture)


(defn collatz [n]
  (if (< n 1) (throw (IllegalArgumentException. "collatz dislikes numbers < 1")))
  (loop [n n
         steps 0]
    (if (= 1 n)
      steps
      (recur 
       (cond (even? n)
             (/ n 2) 

             (odd? n)
             (inc (* 3 n))
             )
       (inc steps)))
    
    )
  )
