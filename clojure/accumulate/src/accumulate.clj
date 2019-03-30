(ns accumulate)

(defn accumulate [fn col] 
  
  ;; (map fn col) ;; this works, but we cant use map

  (loop [cin col
         cout []]
    (if (seq cin) (recur (rest cin)
                         (conj cout (apply fn (list (first cin)))))
        cout)

    )
)

;;(accumulate inc [1 2 3])


