(ns compojure-clojure-test.core-test
  (:require [cheshire.core :as cheshire]
            [clojure.test :refer :all]
            [compojure-clojure-test.handler :refer :all]
            [ring.mock.request :as mock]))

(defn parse-body [body]
  (cheshire/parse-string (slurp body) true)
  )

(use-fixtures
  )

(deftest a-test

  (testing "Test GET request to /hello?name={a-name} returns expected response"
    (let [response (app (-> (mock/request :get  "/api/plus?x=1&y=2")))
          body     (parse-body (:body response))]
      (println response)
      (is (= (:status response) 200))
      (is (= (:result body) 3)))
    ))
