(ns roman-numerals)


;; - map roman numerals to decimal
;; - figure out the largest roman numeral R that fits into the number N
;; - subtract R from N, recurse

(def  roman-numeral-mapping [[1000 "M"]
                             [900 "CM"]
                             [500 "D"]
                             [400 "CD"]
                             [100 "C"]
                             [90 "XC"]
                             [50 "L"]
                             [40 "XL"]
                             [10 "X"]
                             [9 "IX"]
                             [5 "V"]
                             [4 "IV"]
                             [1 "I"]])

(defn largest-numeral-that-fits [number]
  (first (filter (fn [[value letter]] (<= value number)) ;;funky destructuring
                 roman-numeral-mapping)))

;;(largest-numeral-that-fits 500)

(defn numerals [number]
  (if (= 0 number) ""
      (let [[value letter] (largest-numeral-that-fits number)
            remainder (- number value)]
        (str letter (numerals remainder))
        )

      )

  
  )

;;(numerals 1951)
