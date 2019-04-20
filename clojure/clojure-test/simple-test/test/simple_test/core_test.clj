(ns simple-test.core-test
  (:require [clojure.test :refer :all]
            [leiningen.test]
            [simple-test.core :refer :all]))



(defn an-once-fixture  [block]
  (println "the once fixture is being run!")
  (println clojure.test/*testing-contexts*)
  (println clojure.test/*testing-vars*)
;;  (println leiningen.test/*monkeypatch?*)
  (block)
  (println "the once fixture is exiting!")  
  )

(defn an-each-fixture [block]
  (do 
    (println "the each fixture is being run!")
    (block)
    (println "the each fixture is being ended!")
    )
  )

;; :once ficture and :each fixtures require separate calls, or they mutex
(use-fixtures :once an-once-fixture  )
(use-fixtures :each an-each-fixture)



(deftest a-test
  (testing "a test."
    (println "the a-test is being run!")
    (is (= 1 1))))

(deftest   ^:integration a-integration-test
  
  ;; we should test fixtures have been run
  (testing "an integration test."
    (println "the a-inegration-test is being run!")
    (is (= 1 1))))

;;lein run -m circleci.test :integration simple-test.core-test
