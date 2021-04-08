(defproject aocd "0.1.1-SNAPSHOT"
  :description "Load and cache your aoc inputs"
  :url "https://github.com/Thomashrb/advent-of-code-data"
  :license {:name "The MIT License"
            :url "http://opensource.org/licenses/mit-license.php"
            :distribution :repo}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [clj-http "3.12.1"]
                 [cambium/cambium.core "1.1.0"]
                 [cambium/cambium.codec-simple "1.0.0"]
                 [cambium/cambium.logback.core "0.4.4"]]
  :repl-options {:init-ns aocd.core})
