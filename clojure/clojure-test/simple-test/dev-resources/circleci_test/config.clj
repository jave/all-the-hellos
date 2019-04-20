;; from https://github.com/circleci/circleci.test/blob/master/dev-resources/circleci_test/config.clj
(require '[circleci.test.report :refer (clojure-test-reporter)])
(require '[circleci.test.report.junit :as junit])

(def ^:dynamic *inside-global* false)

{:selectors {:all (constantly true)
             :default (complement :integration)
             :integration :integration
             }
 
 :test-results-dir (or (System/getenv "CIRCLE_TEST_REPORTS")
                       "test-results")
 :reporters [clojure-test-reporter junit/reporter]
 :global-fixture (fn [f]
                   (assert (not *inside-global*))
                   (binding [*inside-global* true]
(f)))}
