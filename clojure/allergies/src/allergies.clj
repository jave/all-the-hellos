(ns allergies)

(defn allergies [num]
  (into [](remove nil? (map  #(if (= \1 %1) %2 nil )
                             (reverse (seq (Integer/toBinaryString num)))
                             [:eggs :peanuts :shellfish :strawberries  :tomatoes :chocolate :pollen :cats]     
                             )))
  )

(defn allergic-to? [num allergy] 
  (contains? (into #{}(allergies num)) allergy))


