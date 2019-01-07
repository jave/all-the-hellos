(ns nucleotide-count
  (:use clojure.string
        clojure.algo.generic.functor)
  )

;;this solution uses the frequencies function to count nucleotides
;;but, the return value of frequencies does of course not contain unknown elements, so if there is no A in the input,
;;there will be no \A 0 in the return struct.
;;to hack around this, a minimum of 1 of each nucleotide is insured adding the string AGCT
;;then to decrement, fmap was used
;;i mostly did like this to try "frequencies" and "fmap"
(defn  nucleotide-counts [s]
  (let [freq (frequencies (vec (str s "AGCT")) ) 
        freqdec (fmap dec freq)]
    freqdec)

  )

(defn  count [nucleotide s]
  (if (not (contains? #{\A \G \C \T} nucleotide)) (throw (Exception. "mutant nucleotide" )))
  (get (nucleotide-counts s) nucleotide 0)
  )

;;(nucleotide-counts "AGCTTTTCATTCTGACTGCAACGGGCAATATGTCTCTGTGTGGATTAAAAAAAGAGTGTCTGATAGCAGC") 
;;(count \A "AGAAGA")
;;(count \A "")
;;(nucleotide-counts "")



