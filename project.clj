(defproject cljs-tools "0.0.1"
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [org.clojure/clojurescript "1.10.238"]]
  :plugins [[lein-cljsbuild "1.1.5"]]
  :cljsbuild {:builds [{:id "release"
                        :source-paths ["src"]
                        :compiler {:main yd.module
                                   :output-to "package/index.js"
                                   :target :nodejs
                                   :externs ["externs.js"]
                                   :optimizations :advanced
                                   :pretty-print true
                                   :parallel-build true}}]})
