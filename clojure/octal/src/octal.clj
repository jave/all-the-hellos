(ns octal)

;;more or less the same as the binary and trinary solution
(defn to-decimal [s]
  (if (not (re-seq #"[^01234567]" s))
    (apply + (map-indexed #(* (int (Math/pow 8 %1))  (Character/digit %2 10)) (reverse s)))
    0

    )  
  
  )
