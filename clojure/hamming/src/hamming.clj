(ns hamming)


;;this one turned out well i think
(defn distance2 [dna1 dna2] 
   (get (frequencies (map = (vec dna1) (vec dna2))) false)
)

;;this wrapper turnedd out meh
;; - unequal lenghts, return nil
;; - fixup the case where there are no differences, distance2 returns nil in that case
;; if not= could be replaced with with-not
(defn distance [dna1 dna2]
  (if (not= (count dna1) (count dna2)) nil
      (let [falses (distance2 dna1 dna2)
            realfalses (if (nil? falses) 0 falses)]
        realfalses)
      ))


;;(map (fn [a b] (= a b)) (vec "abcD") (vec "abcd"))

;;(hamming/distance "GGACTGA" "GGACTGA")
;;(hamming/distance "" "")
;;(hamming/distance "AAAC" "TAGGGGAGGCTAGCGGTAGGAC")
;;(count "abs")
