(ns clock
  (:require [clj-time.core :as t]
            [clj-time.format :as f])
  )

;;im going to use a time api here, because that seemed more interesting than
;;building time primitives from scratch
;;clj-time is a wrapper on yoda time, from java

(defn clock->string [c] 
  (f/unparse (f/formatter "HH:mm") c)  
)

;;since i use a date/time api, bludgeoning into a time only api clock becomes a bit contrieved
;;basically the date part is reset after adding hours and minutes
;;otherwise clocks with the same hours and minutes but different dates wont be the same
(defn clock [h m]
  (let [c (t/plus (t/date-time 0 1 1 0 0 ) (t/hours h) (t/minutes m))
        c-normalized (t/date-time 0 1 1 (t/hour c) (t/minute c))]
    c-normalized)
)

(defn add-time [c m]
  (t/plus c  (t/minutes m))  
)
