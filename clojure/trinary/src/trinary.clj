(ns trinary)

;;more or less the same as the binary solution, but, does input checking better
(defn to-decimal [s]
  (if (not (re-seq #"[^012]" s))
    (apply + (map-indexed #(* (int (Math/pow 3 %1))  (Character/digit %2 10)) (reverse s)))
    0

    )  
  
  )


;;(to-decimal "11")
;; (max 0 (Character/digit \b 10))
;;(re-seq #"[^012]" "012")
