(ns yd.transit
  (:require [cognitect.transit :as t]))


(defn encode [data]
  (let [w (t/writer :json)]
    (t/write w data)))


(defn decode [transit-str]
  (let [r (t/reader :json)]
     (t/read r transit-str)))

