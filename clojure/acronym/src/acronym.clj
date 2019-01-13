(ns acronym)

(defn acronym [in] ;; <- arglist goes here
  ;; your code goes here
  (clojure.string/upper-case (clojure.string/join (map (fn [x] (first x)) (clojure.string/split in #"[ -]"))))
  )

;;(clojure.string/upper-case (clojure.string/join (map (fn [x] (first x)) (clojure.string/split "As Sdf F" #" -"))))
