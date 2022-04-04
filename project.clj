(defproject cljs-tools "0.1.0"
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [org.clojure/clojurescript "1.11.4"]]
  :plugins [[lein-cljsbuild "1.1.5"]]
  :cljsbuild {:builds [{:id "release"
                        :source-paths ["src"]
                        :compiler {:main yd.module
                                   :output-to "package/index.js"
                                   :target :nodejs
                                   :hashbang false
                                   :externs ["externs.js"]
                                   :optimizations :advanced
                                   :pretty-print true
                                   :parallel-build true}}]})
