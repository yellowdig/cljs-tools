(ns yd.module
  (:require [yd.edn :refer (encode decode)]))


(def edn #js {})


(aset edn "encode" encode)


(aset edn "decode" decode)


(aset js/module.exports "edn" edn)
