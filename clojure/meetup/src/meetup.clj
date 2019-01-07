(ns meetup
  (:use java-time)
  (:use clojure.spec.alpha)
  )
;;(adjust (local-date 2013 1) :day-of-week-in-month 2 :saturday)

;(adjust now :first-in-month :monday)

(defn teenth [date day]
  (loop [date (adjust date :first-in-month day) ]
    (if (int-in-range?  13 20 (as date :day-of-month))
      date
      (recur (plus  date (days 7))))
    )

  )

;;(teenth (local-date 2013 4) :friday)
;;(as  (local-date 2013 2) :day-of-month)
(defn meetup [month year day thing]
  (let [meetup-date 
        (let [date (local-date year month)]
          (case thing
            :teenth (teenth date day)
            :first (adjust date :first-in-month day)
            :last  (adjust date :last-in-month day)
            :second (adjust date :day-of-week-in-month 2 day)
            :third (adjust date :day-of-week-in-month 3 day)
            :fourth (adjust date :day-of-week-in-month 4 day)
            ))]
    [(as meetup-date :year) (as meetup-date :month-of-year) (as meetup-date :day-of-month)]

    )
  )
