(ns secret-handshake)

(defn commands [num]
  (let [commandlist 
        (into [](remove nil? (map #(if (= \1 %1) %2 nil )
                                  (reverse (seq (Integer/toBinaryString num)))
                                  ["wink" "double blink" "close your eyes" "jump"]
                                  
                                  )))]
    
    (if (> num 15) 
      (reverse commandlist)
      commandlist
      )
    )
)







