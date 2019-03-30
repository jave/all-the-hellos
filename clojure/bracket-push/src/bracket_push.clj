(ns bracket-push
  (:require [clojure.string :as str])
  )

(def pairs {
            \} \{
            \) \(
            \] \[
            }
            )


  
(defn valid? [str]
  (empty? 
   (loop [symlist (seq str)
          stack []]
     (cond
       (empty? symlist)
       stack

       ;; open a pair, so push
       (contains? #{\{ \( \[} (first symlist))
       (recur (rest symlist) (conj stack (first symlist)))

       ;; we are closing a pair, so pop
       (and (last stack) (= (last stack) (get pairs (first symlist)) ))
       (recur (rest symlist) (pop stack))

       ;; trying to close withouth corresponding open, exit false
       (contains? #{\) \] \} } (first symlist))
       [false]

       ;; some other character, skip
       (not (or (contains? #{\) \] \} } (first symlist))
                (contains? #{\{ \( \[} (first symlist))))
       (recur (rest symlist)  stack)
       
       ;;all other cases, exit
       :else
       stack

       )
     ))
)


;; (valid? "({})")
;; (bracket-push/valid? "[[")
;; (bracket-push/valid? "\\\\left(\\\\begin{array}{cc} \\\\frac{1}{3} & x\\\\\\\\ \\\\mathrm{e}^{x} &... x^2 \\\\end{array}\\\\right)")
;; (bracket-push/valid? "({}{}{1}{3}{e}^{x}{}\\\\right)")
;; (bracket-push/valid? "}{")

;; (bracket-push/valid? "{ }")
;; (bracket-push/valid? "(((185 + 223.85) * 15) - 543)/2")

;; (= \( (get pairs \)))

;; (pop '[a b c])
