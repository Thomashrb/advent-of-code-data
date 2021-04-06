(ns aocd.io-test
  (:require [clojure.test :refer :all]
            [aocd.io :refer :all]))

(deftest saved-input-is-loaded
  (testing "Save does not throw"
    (is (nil? (save-input 9999 99 "test"))))
  (testing "Load loads saved input"
    (is (= (load-input 9999 99) "test"))))
