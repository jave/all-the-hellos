(ns isbn-verifier
  (:use clojure.string))

;;check that chars are in set 0-9 and X, replace X with 10
(defn prepare-isbn [isbn]
  (clojure.core/replace {"X" "10"}
                        (filter #(get #{"0" "1" "2" "3" "4" "5" "6" "7" "8" "9" "X"} % ) ;;#(not(= "-" %))
                                (split isbn #""))
                        )
  )

(defn isbn? [isbn]
  (and
   ;;length of isbn must be 10
   (= 10 (count (prepare-isbn isbn)))
   ;;drop the last character, remove remaining x:es, length should now be 9
   (= 9 (count (filter #(not(= "10" %))(rest (clojure.core/reverse (prepare-isbn isbn))))))
   ;;now check according to the algorithm
   (= 0 (mod
         (loop [i 10
                acc 0
                seq
                (prepare-isbn isbn)]
           (cond (= 0 i)
                 acc
                 :else
                 (recur (dec i)
                        (+ acc (* i (read-string (first seq))))
                        (rest seq))))
         11)))

  )

;;`(x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9 * 2 + x10 * 1) mod 11 == 0`

;;"3-598-21508-8"
;;(rseq (filter #(not(= "-" %)) (split "3-598-21508-8" #""))

;;(= 10 (count (prepare-isbn "3-598-21508-A")))
;;(prepare-isbn  "3-598-21507-A")
;;(count (prepare-isbn "3-598-2K507-0"))

;;(mod 264 11)

;;(isbn? "3-598-21507-A")

