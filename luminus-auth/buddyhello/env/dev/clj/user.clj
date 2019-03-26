(ns user
  (:require [buddyhello.config :refer [env]]
            [clojure.spec.alpha :as s]
            [expound.alpha :as expound]
            [mount.core :as mount]
            [buddyhello.core :refer [start-app]]))

(alter-var-root #'s/*explain-out* (constantly expound/printer))

(defn start []
  (mount/start-without #'buddyhello.core/repl-server))

(defn stop []
  (mount/stop-except #'buddyhello.core/repl-server))

(defn restart []
  (stop)
  (start))


