(ns atbash-cipher
  (:require [clojure.set :as setn])
  (:require [clojure.string :as str])

  )




(defn clean-str [s]
  (-> s
      (str/lower-case)
      (str/replace #"[ \.,]" "")
      )
  )

;;(clean-str "Ab c.d")
(defn encode-letter [l]
  (if (< (int l) (int \a))
    l
    (char (+ (int \a)(Math/abs (- (int l)(int \z))))))
  )
;(< (int \0) (int \a))
;;(encode-letter \b)

(defn encode [s] ;; <- arglist goes here
  ;; your code goes here
  (->>
   s
   (clean-str)
   (map encode-letter )
   (partition 5 5 nil)
   (map str/join)
   (str/join " ")
   )
  
  )

;; (encode "abcdefghijklm")

;; ( str/join '(\a \b \c))

;; (= "nrmwy oldrm tob" (atbash-cipher/encode "mindblowingly"))
;; (partition 5 5 nil "mindblowingly")

;; (= "gvhgr mt123 gvhgr mt"
;;          (atbash-cipher/encode "Testing, 1 2 3, testing."))
