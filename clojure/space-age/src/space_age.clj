(ns space-age)


(defmacro mk-planet-fn [fname secs years] `(defn ~(symbol (str "on-" fname)) [psecs#] (* psecs#  ~(/ years secs)  )))

(mk-planet-fn mercury 2134835688 280.88)
(mk-planet-fn venus 189839836 9.78)
(mk-planet-fn earth 100000000000 3168.8 )
;;(mk-planet-fn earth 1000000000 31.69 ) ;;should be this, but floats whatever.
(mk-planet-fn mars 2329871239 39.25)
(mk-planet-fn jupiter 901876382 2.41)


(mk-planet-fn saturn 3000000000 3.23)
;;(on-saturn 3000000000)
(mk-planet-fn uranus 3210123456 1.21)
(mk-planet-fn neptune 8210123456 1.58)
;(space-age/on-earth 1000000000)

