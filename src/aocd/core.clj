(ns aocd.core
  (:require [aocd.api :as api]
            [aocd.io :as io]))

(defn input
  "Attempt to load String input from cache if not exists
  request input from api to cache then load it"
  [year day]
  (or (io/load-input year day)
      (let [token (io/load-token)
            input (api/req-input year day token)]
        (io/save-input year day input) ; Cache the result
        input)))
