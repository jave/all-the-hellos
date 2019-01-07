(ns robot-name)

(defn mk-name []
  ;;you could write it like this
  ;; (str  (char (+ 65 (rand-int 25)))
  ;;       (char (+ 65 (rand-int 25)))
  ;;       (char (+ 48 (rand-int 10)))
  ;;       (char (+ 48 (rand-int 10)))
  ;;       (char (+ 48 (rand-int 10)))
  ;;       )
  ;;or this more obfuscated version
  (clojure.string/join (vec (map (fn [a b](char (+ a (rand-int b))))
                       [65 65 48 48 48]
                       [25 25 10 10 10]  )))
  )
;(mk-name)

(defn robot []
  (atom (mk-name))
   )

(defn robot-name  [r]
  @r)

(defn reset-name [r]
  (reset! r (mk-name))
  )

