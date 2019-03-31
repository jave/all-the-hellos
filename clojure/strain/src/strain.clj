(ns strain)

(defn retain [f col] 

  (loop [incol col
       outcol []
       ]
  (cond
    (empty? incol)
    outcol
    
    (apply f (list (first incol)))
    (recur (rest incol)
               (conj outcol (first incol)))

    :else
    (recur (rest incol) outcol)
        )
  )
)

;;(retain even? [1 2 3 4 5 6])
;;(discard even? [1 2 3 4 5 6])



(defn discard [f col]
  (retain #(not (f %)) col)
)
