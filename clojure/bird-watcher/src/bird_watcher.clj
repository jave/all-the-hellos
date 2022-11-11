(ns bird-watcher)

(def last-week 
[0 2 5 3 7 8 4]  )

(defn today [birds]
  (last birds)
  )

(defn inc-bird [birds]
  (update birds (dec (count birds)) inc) ;; update the last slot in the vector, incrementing it
  )

(defn day-without-birds? [birds]
  ;; see if the count of 0 elemets in the birds vector is positive
  (pos? (count (filter zero? birds)))
  )

(defn n-days-count [birds n]
  ;; take the 1st n elements of birds in a new vector, reduce with +, end will be sum
   (reduce + (take n birds))
  )

(defn busy-days [birds]
  ;; filter so that days with count >= 5 remains, count the remaining elemts
   (count (filter #(>= % 5) birds))
  )

(defn odd-week? [birds]
  ;; just check if the week is exactly as asked for a more "clever"
  ;; solution might involve looping, and compairing with a mod op but
  ;; real world problem of actual birds, this one is better i think,
  ;; because there might be other odd weeks, with unforseen patterns
    (= birds [1 0 1 0 1 0 1])
  )
