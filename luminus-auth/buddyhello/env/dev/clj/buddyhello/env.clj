(ns buddyhello.env
  (:require [selmer.parser :as parser]
            [clojure.tools.logging :as log]
            [buddyhello.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[buddyhello started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[buddyhello has shut down successfully]=-"))
   :middleware wrap-dev})
