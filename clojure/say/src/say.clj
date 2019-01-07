(ns say
    (:use clojure.string))


(def numlist {
              0 "" ;; or "zero"?
              1 "one"
              2 "two"
              3 "three"
              4 "four"
              5 "five"
              6 "six"
              7 "seven"
              8 "eight"
              9 "nine"
              10 "ten"
              11 "eleven"
              12 "twelve"
              13 "thirteen"
              14 "fourteen"
              15 "fifteen"
              16 "sixteen"
              17 "seventeen"
              18 "eighteen"
              19 "nineteen"
              20 "twenty"
              30 "thirty"
              40 "forty"
              50 "fifty"
              60 "sixty"
              70 "seventy"
              80 "eighty"
              90 "ninety"
              100 "hundred"})

(defn num0-100 [num]
  (cond
    (> 20 num)   (get numlist num)
    :else (str
           (get numlist (int (* 10 (int (/ num 10)))))
           (if (not (= 0 (rem num 10))) "-" "")
           (get numlist (rem num 10)))

    )  )
;;(num0-100 100)
(defn num0-999 [num]
  (str (if (> num 99) (str (get numlist (int (* 1 (int (/ num 100))))) " hundred "))
       (num0-100 (rem num 100))))
;;(num0-999 100)

(defn thousands [n]
  (loop [n n
         tlist '()]
    (if (= 0 n)
      tlist
      (recur (int (/ n 1000))
             (conj tlist (rem n 1000))))))

;;(thousands 1234567890)
(def scaleword
  {0 ""
   1 "thousand"
   2 "million"
   3 "billion"
   4 "gazillion"}
  )
;;(reverse (map-indexed (fn [idx itm] (str  " " (num0-999 itm) " " (get scaleword idx ))) (reverse (thousands 1234567890))))

(defn number [num] ;; <- arglist goes here
  ;; your code goes here
  (if (< num 0) (throw (IllegalArgumentException. "bad")))
  (if (> num 999999999999) (throw (IllegalArgumentException. "bad")))
  (if (= num 0) "zero"
      (trim(join(clojure.core/reverse
                 (map-indexed (fn [idx itm]
                                (if (> itm 0)
                                  (str (num0-999 itm) " " (get scaleword idx ) " ")
                                  " "))
                                (clojure.core/reverse (thousands num))
                                ))
                              )))
           )


;;(number 1234567890)
;;(say/number 0)
;;(say/number 1000000)
;;(say/number 1000000000)
;;(say/number 987654321123)

;;(say/number 100)

