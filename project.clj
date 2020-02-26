(defproject cljs-tools "0.0.1"
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [org.clojure/clojurescript "1.10.597"]
                 [com.cognitect/transit-cljs "0.8.256"]]
  :plugins [[lein-cljsbuild "1.1.7"]]
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
