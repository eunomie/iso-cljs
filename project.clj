(defproject demo "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"

  :min-lein-version "2.6.1"

  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.9.76"]
                 [reagent "0.6.0-rc"]
                 [secretary "1.2.3"]
                 [kibu/pushy "0.3.1"]]

  :plugins [[lein-cljsbuild "1.1.3"]]

  :clean-targets ^{:project false} ["resources"]

  :cljsbuild {
              :builds [{:id "server"
                        :source-paths ["src" "src-server"]
                        :compiler {
                                   :main demo.server
                                   :output-to "resources/public/js/server-side/server.js"
                                   :output-dir "resources/public/js/server-side"
                                   :target :nodejs
                                   :optimizations :none
                                   :source-map true}}
                       {:id "app"
                        :source-paths ["src" "src-client"]
                        :compiler {
                                   :output-to "resources/public/js/app.js"
                                   :output-dir "resources/public/js"
                                   :optimizations :none
                                   :source-map true}}]})
