(ns phone-number
  (:require [instaparse.core :as insta]
            [clojure.string :as str]))




;;I wanted to try instaparse for this
(def phone-insta
  (insta/parser
   "phonenumber =  areacode <'.'> numberblock <'.'> fournumberblock |
<'('> areacode <') '> numberblock <'-'> fournumberblock |
<'1'> areacode numberblock fournumberblock |
areacode numberblock fournumberblock ;
areacode =  numberblock;
<numberblock> = #'[0-9]{3}' ;
<fournumberblock> =  #'[0-9]{4}'

"
   ))

;;(phone-insta "(123) 456-7890")
;;(phone-insta "555.867.5309")
;;(phone-insta  "1234567890")
;;(nth [:phonenumber [:areacode "987"] "654" "3210"] 3)



(defn area-code [s]
  (second (second (phone-insta s)))
  )

(defn pretty-print [s]
  (let [p (phone-insta s)]
    (str "(" (area-code s) ") " (nth p 2) "-" (nth p 3))))
    

;;this got a bit sloppy. the original idea was to not use instaparse for this bit(for no real reason),
;;but i think just using the parser for all cases would be neater
(defn number [s]
  (let [s   (str/replace s #"[^0-9]" "")]
  (cond
    (and (not= (subs s 0 1) "1") (>= (count s) 11)) "0000000000"
    (<= (count s) 9) "0000000000"
    :else
    (str/replace (pretty-print s) #"[^0-9]" "")
  )))
