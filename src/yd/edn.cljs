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


(defn encode [js-data keywordize?]
  (cond-> (js->clj js-data) 
      keywordize? (walk interpret-kw) 
      true pr-str))


(defn decode [edn-str keywordize?]
  (cond-> (read-string edn-str)
    keywordize? (walk print-kw)
    true clj->js))
    

