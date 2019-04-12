(ns diamond
  (:require [clojure.set :as setn])
  (:require [clojure.string :as str])
  )

(defn pad [num-pads]
  (str/join (repeat num-pads " ")))

(defn row [letter pad-inner pad-outer]
  (cond (zero? pad-inner) (str
                           (pad pad-outer) letter (pad pad-outer))
        :else
        (str       (pad pad-outer) letter (pad pad-inner) letter (pad pad-outer) )

        ))

;;(row "a" 3 3)

(defn diamond-helper [num-rows]
  (map (fn [letter [pad-inner pad-outer]]  (row letter pad-inner pad-outer))

       (map (fn [x] (str (char (+ (int \A) x))))   (range (inc num-rows)) ) ;;collection of letters
       (map (fn [inner-pad outer-pad] [inner-pad outer-pad]) ;; here a collection of inner, outer paddings ([0 1] [1 0]) etc
            (conj (iterate (partial + 2) 1) 0) ;; the inner padding is a bit tricky, generate (0 1 3 5 7)
            (iterate dec num-rows) ;; the outher padding just decrements from max
            )))

(defn diamond [letter]
  (into []
        (let [toprows   (diamond-helper (- (int letter)(int \A)))]
          (concat toprows  (rest (reverse toprows))))))


;; ;;--------------

;; (take 7 (iterate dec 7))
;; (let [num-rows 2]
;;   (map (fn [x] [x (- num-rows x)]) (range  (inc num-rows))))


;; ([0 2] [1 1] [2 0])
;; ([0 2] [1 1] [3 0])


;; (is (= (diamond \C)
;;        ["  A  "
;;         " B B "
;;         "C  C"
;;         " B B "
;;         "  A  "]
;;        ["  A  "
;;         " B B "
;;         "C   C"
;;         " B B "
;;         "  A  "]))


;; (take 5      (conj (iterate (partial + 2) 1) 0)       )

;; (concat '("a" "b") '("c" "d"))

;; (str (char (+ (int \A) 1 )))



;; (is (= (diamond \D)
;;        ["   A   "
;;         "  B B  "
;;         " C  C "
;;         "D   D" " C  C " "  B B  " "   A   "]


;;        ["   A   "
;;                      "  B B  "
;;                      " C   C "
;;                      "D     D"
;;                      " C   C "
;;                      "  B B  "
;;                      "   A   "]))


;; ;;(pad 5)
