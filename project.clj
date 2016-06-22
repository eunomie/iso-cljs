(defproject demo "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"

  :min-lein-version "2.6.1"

  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.9.76"]]

  :plugins [[lein-cljsbuild "1.1.3"]]

  :clean-targets ^{:project false} ["resources"]

  :cljsbuild {
              :builds [{:id "server"
                        :source-paths ["src-server"]
                        :compiler {
                                   :main demo.server
                                   :output-to "resources/public/js/server-side/server.js"
                                   :output-dir "resources/public/js/server-side"
                                   :target :nodejs
                                   :optimizations :none
                                   :source-map true}}]})
