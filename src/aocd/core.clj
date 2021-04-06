(ns aocd.core
  (:require [aocd.api :as api]
            [aocd.io :as io]))

(defn input
  "Attempt to load `String` input from cache if not exists
  request input from api to cache then load it"
  [year day]
  (let [token (io/load-token)]
    (try (io/load-input year day)
         (catch java.io.FileNotFoundException _
           (->> (api/req-input year day token)
                (io/save-input year day))
           (io/load-input year day)))))
