(ns elyses-destructured-enchantments)

(defn first-card
  "Returns the first card from deck."
  [[first _]]
  first
)

(defn second-card
  "Returns the second card from deck."
  [[_ second _]]
  second
)

(defn swap-top-two-cards
  "Returns the deck with first two items reversed."
  [[first second & rest]]
  (conj rest first second)
)

(defn discard-top-card
  "Returns a vector containing the first card and
   a vector of the remaining cards in the deck."
  [[first & rest]]
  [first rest]
)

(def face-cards
  ["jack" "queen" "king"])

(defn insert-face-cards
  "Returns the deck with face cards between its head and tail."
  [[first & rest]]
  (remove nil? (flatten [first face-cards rest]))
)
