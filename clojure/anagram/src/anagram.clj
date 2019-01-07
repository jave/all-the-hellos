(ns anagram
  (:use clojure.string)
  )

(defn str-to-sorted-list [s]
  (sort (split (lower-case s) #"")))

;;this code should be refactored a bit because it isnt really readable
;;loops over anagram-candidates, checks if anagram or not, push it on to list if so
;;case insensitive comparisisons
;;a string is not its own anagram
(defn anagrams-for [s anagram-candidates] ;; <- arglist goes here
  ;; your code goes here
  (loop [anagrams []
         anagram-candidates anagram-candidates
         ]
    (if (empty? anagram-candidates) anagrams
        (recur
         (if (and(not(= (lower-case s) (lower-case (first anagram-candidates))))
                 (= (str-to-sorted-list s) (str-to-sorted-list (first anagram-candidates))))
           (conj anagrams (first anagram-candidates))
           anagrams)
         (rest anagram-candidates)))))

;;(anagram/anagrams-for "ant" ["tan" "stand" "at"])

;;(=(sort (split "lorgar" #"")) (sort (split "arlorg" #"")))
