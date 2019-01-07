(ns rna-transcription
  (:use clojure.string)
  )

(defn rna-map [x]
  (cond (= "C" x) "G"
        (= "G" x) "C"
        (= "A" x) "U"
        (= "T" x) "A"
        :else (throw (AssertionError. "bad rna"))
        )

  )
(defn to-rna [dna] ;; <- arglist goes here
  ;; your code goes here
  (join (map rna-map (split dna #"")))
)
