(ns hexadecimal)


;;more or less the same as the binary, trinary, and octal solution
(defn hex-to-int [s]
  (if (not (re-seq #"[^0123456789abcdef]" s))
    (apply + (map-indexed #(* (int (Math/pow 16 %1))  (Character/digit %2 16)) (reverse s)))
    0

    )  
  
  )
