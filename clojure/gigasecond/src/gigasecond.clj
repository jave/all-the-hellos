(ns gigasecond
  (:require [ java-time :as jtime])
  )

(defn from [y m d]
  (jtime/as (jtime/plus (jtime/local-date-time y m d  ) (jtime/seconds 1000000000))
            :year :month-of-year :day-of-month)
)
