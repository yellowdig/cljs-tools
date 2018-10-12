(ns yd.edn-test
  (:require [clojure.test :refer (deftest is)]
            [yd.edn :refer (encode decode)]))

;; encoding from js values to edn values

(def test-str-1 
  "{ \":user/username\": \"hello\" }")


(def test-str-2 
  "{ \":board/settings\": { \":board-settings/read-only\" : true  } }")


(def test-str-3
  "{ \":user/string\": \"40\" }")


(defn test1 []
  (let [js-data (js/JSON.parse test-str-1)
        encoded (encode js-data true)]
    (println encoded)
    (assert (= "#:user{:username \"hello\"}" encoded))))


(defn test2 []
  (let [js-data (js/JSON.parse test-str-2)
        encoded (encode js-data true)]
    (println encoded)))


(defn test3 []
  (let [js-data (js/JSON.parse test-str-3)
        encoded (encode js-data true)]
    (println encoded)
    (assert (= "#:user{:string \"40\"}" encoded))))

