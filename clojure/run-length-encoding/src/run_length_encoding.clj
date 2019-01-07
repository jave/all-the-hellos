(ns run-length-encoding
  (:use clojure.string
        clojure.walk)
  (:require [instaparse.core :as insta])
  )

(defn run-length-encode-2
  "encodes a string with run-length-encoding"
  [s]

  (loop [in  (rest (split s #""))
         out nil
         prev (first   (split s #""))
         run 1]
;    (println in out prev run)

    (cond
      (empty? in)
      (concat   out (list  run prev ) )
      
      (= (first in) prev)
      (recur (rest in) out (first in) (inc run))

      :else
      (recur (rest in) (concat   out (list run prev ) ) (first in) 1)
    )
  ))

(defn run-length-encode [s]
  (join (filter #(not= % 1) (run-length-encode-2 s))))
;;(run-length-encode "aaaabbbbbbcccdb")

;;(split "12bd3A22C" #"(?=[a-zA-Z])|(?<=[a-zA-Z])") => ["12" "b" "d" "3" "A" "22" "C"]
;;split either on letter to the right, or letter to the left

;;the above would work, but i want to play with instaparse now

(def as-and-bs
  (insta/parser
    "S = AB*
     AB = A B
     A = 'a'+
     B = 'b'+"))
;;(as-and-bs "aaaaabbbaaaabb")

(def run-length-insta
  (insta/parser
    "S = RUN*
     RUN = number symbol
     number = #'[0-9]*'
     symbol = #'[a-zA-Z ]'"))

;;(run-length-insta "12bd3A22C") => [:S [:RUN [:number "12"] [:symbol "b"]] [:RUN [:number ""] [:symbol "d"]] [:RUN [:number "3"] [:symbol "A"]] [:RUN [:number "22"] [:symbol "C"]]]

                                           

;(map #(:RUN %) (rest (run-length-insta "12bd3A22C")))

(defn decode-RUN [run]
  (let [[s1 nseq sseq] run
        [s2 lenght] nseq
        [s3 sym] sseq
        lenght2 (if (= "" lenght) "1" lenght)
        ]
    (join (repeat (read-string lenght2) sym))
    )
  )
;;(decode-RUN [:RUN [:number "12"] [:symbol "b"]])
;;(decode-RUN [:RUN [:number ""] [:symbol "b"]])

;;(join (map decode-RUN (rest (run-length-insta "12bd3A22C"))))

;; (:symbol (nth  (first (rest (run-length-insta "12bd3A22C"))) 2))

;; (into {} (:RUN [:RUN [:number "12"] [:symbol "b"]]))

;; ; use postwalk?
;; (postwalk #(println %) (run-length-insta "12bd3A22C"))

(defn run-length-decode
  "decodes a run-length-encoded string"
  [s]
  (join (map #(decode-RUN %) (rest (run-length-insta s))))
  )

;;(run-length-encode "")
;;(run-length-decode (run-length-encode "zzz ZZ  zZ"))
;;(run-length-decode "12WB12W3B24WB")
