(ns raindrops)

(defn divisable? [n i]
  (= 0 (mod n i)))


(defn convert [n]

  (let [rv  (clojure.string/join "" (map #(if (divisable? n (first %)) (second %) "" ) [[3 "Pling"] [5 "Plang"][ 7 "Plong"]]))]
    (if (= "" rv) (str n) rv)
    )
  
      
)


