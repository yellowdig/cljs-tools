(ns yd.edn
  (:require [clojure.walk :refer (postwalk)]
            [clojure.string :refer (replace)]
            [cljs.tools.reader :refer (read-string)]))


(defn interpret-kw [k-str]
  (if (and (string? k-str)
           (.startsWith k-str ":"))
    (-> k-str
        (replace ":" "")
        (keyword))
    k-str))


(defn print-kw [x]
  (if (keyword? x) (str x) x))


(defn walk [m tag-fn]
  (let [f (fn [[k v]] [(tag-fn k) (tag-fn v)])]
    (postwalk (fn [x] (if (map? x) (into {} (map f x)) (tag-fn x))) m)))


(defn encode [js-data]
  (-> js-data js->clj (walk interpret-kw) pr-str))


(defn decode [edn-str]
  (-> edn-str read-string (walk print-kw) clj->js))


