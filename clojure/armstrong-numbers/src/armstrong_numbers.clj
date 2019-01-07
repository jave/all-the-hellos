(ns armstrong-numbers
  (:use clojure.string))



;;was offline when i did this, and couldnt find the inbuilt expt function
;;so i made this
(defn my-expt [base exp]
  (loop [ exp exp acc 1]  (if (= 0 exp) acc (recur  (dec exp) (* acc base)))))

;;(my-expt 2 5)
;;(map-indexed (fn[idx digit] (* 10 idx)) (split "123456" #""))



(defn armstrong? [n]
  (let [numstr (str n)
        exp (count numstr)
        explist  (map-indexed (fn[idx digit] (my-expt (read-string digit) exp)) (clojure.core/reverse (split numstr #"")))
        sum (apply + explist)
        ]
    (= n sum)
    ))

;;(armstrong? 153)
;;(armstrong? 9474)
;;(armstrong? 9)




