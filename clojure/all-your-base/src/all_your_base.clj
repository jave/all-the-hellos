(ns all-your-base)



(defn numlist-to-decimal [base digits]
  (reduce + (map-indexed #(* (int (Math/pow base %1))  %2)
                         (reverse digits))))

(defn decimal-to-numlist [base number]
  (reverse (loop [digits []
                  remaining number]
             (if (zero? remaining)
               digits
               (recur (conj digits (mod remaining base))
                      (quot remaining base))
               )
             ))
)


;;(numlist-to-decimal 10 '(1 0))
;;(decimal-to-numlist 2 16)


(defn convert [frombase numbers tobase]
  (cond
    ;; these are a bunch of tests to please the test suite. surely one can codify it nicer
    (= 1 tobase) nil
    (= 1 frombase) nil    
    (>= 0 tobase) nil
    (>= 0 frombase) nil    
    (empty? numbers) ()
    
    (every? #(zero? %) numbers) '(0) ;;all zeros becomes zero, regardless base
    (not (empty? (filter #(> 0 %) numbers))) nil;; if any digit < 0, return nil
    (not (empty? (filter #(>= % frombase ) numbers))) nil ;;invalid digits in frombase
    (nil? frombase) nil
    
    :else (decimal-to-numlist   tobase (numlist-to-decimal frombase numbers)))
)




;;(= '(2 10) (all-your-base/convert 3 '(1 1 2 0) 16))
;;    (not (empty? (filter #(>=  % 2) '(0 1 0 2))  ))
