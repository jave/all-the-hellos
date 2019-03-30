(ns pangram
  (:require [clojure.set :as setn])
  (:require [clojure.string :as str]))

(defn pangram? [s]
  (empty? (setn/difference 
           (set (seq "abcdefghijklmnopqrstuvwxyz"))
           (set (seq (str/lower-case s)))))
)




