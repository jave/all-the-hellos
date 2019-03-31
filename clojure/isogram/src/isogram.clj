(ns isogram)

(defn isogram? [sin]  
  (let [s (clojure.string/replace (clojure.string/lower-case sin) #"[ -]" "")]
    (=   (count s)
         (count (set (seq s)))))
)

