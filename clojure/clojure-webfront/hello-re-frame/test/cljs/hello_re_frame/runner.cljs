(ns hello-re-frame.runner
    (:require [doo.runner :refer-macros [doo-tests]]
              [hello-re-frame.core-test]))

(doo-tests 'hello-re-frame.core-test)
