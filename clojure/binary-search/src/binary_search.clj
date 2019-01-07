(ns binary-search)

(defn middle
  ([l] 
   (quot (dec (count l)) 2))
  ([start end]
   (+ start  (quot (- end start ) 2))
   )
)


(defn search-for
  ([x l] (search-for x l 0  (count l)))
  ([x l start end] 
   ;; your code goes here
   (let* [mpos (middle start end)
          m (nth l mpos)
          ]
     (cond
       (= x m) mpos
       (= (inc mpos) end) (throw (Exception. "not found"))
       (< x m) (search-for x l   start mpos)
       (> x m) (search-for x l   mpos  end)
       
       :else "uh oh"
       )))
  )


;;(middle 0 1)
;;(subvec (middle ) )

;;012345678
;;    <
;; >
;;  = 
