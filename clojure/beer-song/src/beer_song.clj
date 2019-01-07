(ns beer-song)

(defn verse
  "Returns the nth verse of the song."
  [n]

  (if (zero? n )
      (str "No more bottles of beer on the wall, no more bottles of beer.\n"
       "Go to the store and buy some more, 99 bottles of beer on the wall.\n")
  (format "%s bottle%s of beer on the wall, %s bottle%s of beer.
Take %s down and pass it around, %s of beer on the wall.\n"
          n (if (= 1 n) "" "s")
          n (if (= 1 n) "" "s")
          (if (= 1 n) "it" "one")
          (cond
            (= 1 n) "no more bottles"
            (= 2 n) "1 bottle"
            :else (str (dec n) " bottles")
          )
  )))

;;(verse 99)
;;(verse 2)
;;(verse 1)
;;(verse 0)

(defn sing
  "Given a start and an optional end, returns all verses in this interval. If
  end is not given, the whole song from start is sung."
  ([start] (sing start 0))
  ([start end]
   (loop [n start
          acc ""]
     (if (= (dec end) n)
       acc
       (recur (dec n)
              (str acc (verse n) (if (=  end n) "" "\n" ) ))
       )

     )))

;;(sing 8 6)
