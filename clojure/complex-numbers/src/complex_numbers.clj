(ns complex-numbers)

(defn real [[a b]]
  a)

(defn imaginary [[a b]]
  b)

(defn abs [[a b]]

  (Math/sqrt (+ (* a a) (* b b)))
  )

(defn conjugate [[a b]]
  [a (- b)])

(defn add [[a b] [c d]]
  [(+ a c) (+ b d)]
  )

(defn sub [[a b] [c d]]
  [(- a c) (- b d)]
  )

(defn mul [[a b] [c d]]
  [(- (* a c) (* b d))
   (+ (* b c) (* a d))]
  )

(defn div [[a b] [c d]]
  (let [namnare (+ (Math/pow c 2) (Math/pow d 2))]
    [(float (/ (+ (* a c) (* b d))
               namnare))

     (float (/ (- (* b c) (* a d))
               namnare))
     ])

  )
