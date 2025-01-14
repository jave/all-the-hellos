 (defproject compojure-clojure-test "0.1.0-SNAPSHOT"
   :description "FIXME: write description"
   :dependencies [[org.clojure/clojure "1.10.0"]
                  ;;[metosin/compojure-api "1.1.11"]
                  [metosin/compojure-api "2.0.0-alpha30"  :exclusions [ring/ring-codec commons-codec  com.fasterxml.jackson.core/jackson-core]]
                  ]
   :ring {:handler compojure-clojure-test.handler/app}
   :uberjar-name "server.jar"
   :profiles {:dev {:dependencies [[javax.servlet/javax.servlet-api "3.1.0"]
                                   [cheshire "5.8.1"]
                                  [ring/ring-mock "0.3.0"]]
                   :plugins [[lein-ring "0.12.0"]]}})
