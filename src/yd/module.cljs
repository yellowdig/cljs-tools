(ns yd.module
  (:require [yd.edn :refer (encode decode decode-transit)]))


(def edn #js {})


(aset edn "encode" encode)


(aset edn "decode" decode)


(aset edn "decodeTransit" decode-transit)


(aset js/module.exports "edn" edn)
