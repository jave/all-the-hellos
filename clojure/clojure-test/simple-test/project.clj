(defproject simple-test "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                                  
                 [leiningen "2.9.0"]
                 ]
  :repl-options {:init-ns simple-test.core}

  ;; leiningen test plugin
  :test-selectors {:default (complement :integration)
                   :integration :integration
                 }
  
  :aliases {"cci/test" ["run" "-m" "circleci.test/dir" :project/test-paths]
            "cci/tests" ["run" "-m" "circleci.test"]
            "cci/retest" ["run" "-m" "circleci.test.retest"]
            "kaocha" ["with-profile" "+kaocha" "run" "-m" "kaocha.runner"] ;;for kaocha
            }
  
  :profiles{
            :dev [:project/dev :profiles/dev]
            :project/dev {
                          :dependencies [
                                         [circleci/circleci.test "0.4.2"];; should go to a dev profile
                                         ]
                          :resource-paths ["dev-resources"]
                          }
            :profiles/dev {}

            ;;for kaocha
            :kaocha {:dependencies [[lambdaisland/kaocha "0.0-418"]]}
            }
  
  )
