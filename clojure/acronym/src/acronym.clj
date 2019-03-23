(ns acronym)

(defn acronym [in]
  
  (clojure.string/upper-case (clojure.string/join (map (fn [x] (first x)) (clojure.string/split in #"(?<=[a-z])(?=[A-Z])|[ -]"))))
  )

;;(clojure.string/upper-case (clojure.string/join (map (fn [x] (first x)) (clojure.string/split "As Sdf F" #" -"))))
;;(acronym "HejSvejs På Dig")
