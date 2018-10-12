(ns yd.edn
  (:require [clojure.walk :refer (postwalk)]
            [clojure.string :refer (replace includes?)]
            [cljs.tools.reader :refer (read-string)]))


(defn keylike? [k-str]
  (and (string? k-str)
       (.startsWith k-str ":")))


(defn keywordize [k-str]
  (-> k-str
      (replace ":" "")
      (keyword)))


(defn interpret-key [k-str]
  (cond
    (keylike? k-str) (keywordize k-str)
    true k-str))


(defn try-read [value]
  (try
    (read-string value)
    (catch js/Error e nil)))


;; 1. if value is a url, treat it as a string literal
;; 2. js cannot distinguish between symbols vs strings, thus don't allow encoding of symbols
(defn interpret-val [value]
  (let [read-val (try-read value)]
    (cond
      (string? value)
      (cond
        (includes? value "//") value
        (symbol? read-val) value
        :else read-val))))


(defn print-kw [x]
  (if (keyword? x) (str x) x))


(defn walk [m key-fn val-fn]
  (let [f (fn [[k v]] [(key-fn k) (val-fn v)])]
    (postwalk (fn [x] (if (map? x) (into {} (map f x)) (key-fn x))) m)))


(defn encode [js-data keywordize?]
  (cond-> (js->clj js-data) 
      keywordize? (walk interpret-key interpret-val) 
      (not keywordize?) (walk identity interpret-val)
      true pr-str))


(defn decode [edn-str keywordize?]
  (cond-> (read-string edn-str)
    keywordize? (walk print-kw identity)
    true clj->js))
    

