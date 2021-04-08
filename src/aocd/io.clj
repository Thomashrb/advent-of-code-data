(ns aocd.io
  (:require [clojure.java.io :as cio]
            [cambium.core  :as log]))

(def conf-path
  "$HOME/.config/aocd"
  (str (System/getProperty "user.home") "/.config/aocd"))

(defn load-token
  "Attempt to load token from AOC_SESSION_TOKEN or `~/.config/aocd/token`"
  []
  (or (System/getenv "AOC_SESSION_TOKEN")
      (slurp (str conf-path "/token"))))

(defn- input-path
  "Constuct the path where input is stored
  $HOME/.config/aocd/{year}/{day}/input.txt"
  [year day]
  (str conf-path "/" year "/" day "/input.txt"))

(defn save-input
  "Attempt to save input
  creating the input directory if not exists"
  [year day input]
  (let [path (input-path year day)]
    (cio/make-parents path)
    (spit path input))
  (log/info "Input cached"))

(defn load-input
  "Attempt to load input as String,
  when input file is not found return nil"
  [year day]
  (try
    (let [input (slurp (input-path year day))]
      (log/info "Input loaded from cache")
      input)
    (catch java.io.FileNotFoundException _ (log/error "Could not load input"))))
