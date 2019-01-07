(ns word-count
  (:use clojure.string)
  )

(defn prepare-input [input]
  (map lower-case
       (filter #(not (= "" %)) ;; i think it should be possible to write the split so that the filter isnt needed
               (split input #"[^a-zA-Z0-9]"))))

;; this thing works by looping over the washed input one by one, until empty
;; increment the counter for each word encountered, if nil, start at 1
(defn word-count [input] 
  (loop [l (prepare-input input)
         h {}]
    (if (empty? l) h
        (recur (rest l)
               (update h
                       (first l)
                       #(if (nil? %) 1 (inc %)) ))))
  
  )

;;(word-count/word-count "word")
;;(word-count/word-count "one of each")
