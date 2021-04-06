(ns aocd.api
  (:require [clj-http.client :as client]
            [cambium.core  :as log]))

(defn- input-url
  [year day]
  (str "https://adventofcode.com/" year "/day/" day "/input"))

(defn req-input
  "Get input for a given `year` `day` with `token`
  if token is not provided one will be attempted loaded with `(load-token)`
  The resulting input will if not exists be downloaded,
  cached in `resources/` and subsequently loaded as a String"
  ([year day token]
   (let [user-agent "advent-of-code-data clojure-v1"]
     (log/info "Requesting input from AoC api")
     (->
      (client/get (input-url year day)
                  {:headers {"Cookie" (str "session=" token), "User-Agent" user-agent}})
      :body))))
