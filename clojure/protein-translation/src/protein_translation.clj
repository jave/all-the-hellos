(ns protein-translation)

(def codons
  '(
    (("AUG")                  "Methionine")
    (("UUU" "UUC")              "Phenylalanine")
    (("UUA" "UUG")              "Leucine")
    (("UCU" "UCC" "UCA" "UCG")     "Serine")
    (("UAU" "UAC")              "Tyrosine")
    (("UGU" "UGC")               "Cysteine")
    (("UGG")                   "Tryptophan")
    (("UAA" "UAG" "UGA")         "STOP")
    ))



(defn eachcodon [col 
                 prot
                 codonlist]
  (reduce merge (map #(assoc col % prot) codonlist)))

(defn allcodons []
  (reduce merge (map #(eachcodon {} (second %) (first %)) codons)))

(def maincodonlist (allcodons))





(defn translate-codon [r]
  (get maincodonlist r)
  )

(defn three-split [s]
  (re-seq #"..." s)
  )

(defn translate-rna [r]
  (take-while #(not (= "STOP" %)) (map translate-codon (three-split r)) )
  )

