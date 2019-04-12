(ns queen-attack
  (:require [clojure.set :as setn])
  (:require [clojure.string :as str]))

(defn board-string [piece-positions]  
  ;;piece-positions {:w [2 4] :b [6 6]}

  (apply str (let [pos-to-piece  (setn/map-invert piece-positions)] 
               (map #(str % "\n")
                    (->> 
                     (for [x (range  8)
                           y (range  8)]
                       (str/upper-case (name (or (pos-to-piece [x y]) "_"))) )
                     (partition 8)
                     (map #(clojure.string/join " " %)  )
                     
                     ))))
  )



(defn can-attack-coords [x1 y1
                         x2 y2]

  (or (= x1 x2) ;; same x
      (= y1 y2) ;; same y

      (= (- x1 x2) (- y1 y2)) ;; add the same constant to both x1 and y2, wind up in x2 y2 => diagonal matching
      
      )
  )

(defn can-attack [piece-positions] ;; <- arglist goes here
  ;; your code goes here
  (can-attack-coords (first (:w piece-positions)) (second (:w piece-positions))
                     (first (:b piece-positions)) (second (:b piece-positions))
                     )
  
  )





;; (queen-attack/board-string {:w [2 4] :b [6 6]})
;; (apply str (queen-attack/board-string {}))


;; ;;false
;; (queen-attack/can-attack {:w [2 3] :b [4 7]})

;; ;;true
;; (queen-attack/can-attack {:w [2 4] :b [2 7]})


;; (let [pos-to-piece  (clojure.set/map-invert {:w [2 4] :b [6 6]})]
;;   (map clojure.string/join
;;        (partition 8(for [x (range 1 8)
;;                          y (range 1 8)]
;;                      (or (pos-to-piece [x y]) "_")
;;                      ))))

;; ->>

;; (clojure.string/upper-case (name :w))

;; (let [pos-to-piece  (clojure.set/map-invert {:w [2 4] :b [6 6]})] 
;;   (map #(str % "\n")
;;        (->> 
;;         (for [x (range 1 8)
;;               y (range 1 8)]
;;           (clojure.string/upper-case (name (or (pos-to-piece [x y]) "_"))) )
;;         (partition 8)
;;         (map #(clojure.string/join " " %)  )
        
;;         )))

;; (queen-attack/board-string {:w [2 4] :b [6 6]})

;; (or ((clojure.set/map-invert {:w [2 4] :b [6 6]}) [2 4]) "x" )
