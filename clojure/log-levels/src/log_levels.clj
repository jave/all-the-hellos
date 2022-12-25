(ns log-levels
  (:require [clojure.string :as str]))


(defn parse-log [s]
  (let [[_ log_level message]   (re-matches #"\[(.*)\]:\s*(.*)\s*" s)]
    (if log_level ;; parse was sucessfu
      (list (str/lower-case log_level) (str/trim message))
      nil ;; we failed, return nil for now, or maybe exception later
      )
    )
)

(defn message
  "Takes a string representing a log line
   and returns its message with whitespace trimmed."
  [s]
  (first (rest (parse-log s)))
  )

(defn log-level
  "Takes a string representing a log line
   and returns its level in lower-case."
  [s]
  (first (parse-log s))
  )

(defn reformat
  "Takes a string representing a log line and formats it
   with the message first and the log level in parentheses."
  [s]
  (format "%s (%s)" (message s)  (log-level s))
  )

;; (log-levels/message "[ERROR]: Stack overflow")
