(ns squiggly-test.core)

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))


(defn fly-tests []
  (inc "foo")
  (map inc [1 2 3])
  (+ 3))


(defn foo2
  [x]
  "Bad doc string placement"
  (* x x))

