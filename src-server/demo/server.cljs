(ns demo.server
  (:require [cljs.nodejs :as nodejs]
            [site.tools :as tools]))

(nodejs/enable-util-print!)

(def express (nodejs/require "express"))
(def serve-static (nodejs/require "serve-static"))

(defn handle-request [req res]
  (.send res (tools/render-page (.-path req))))

(defn -main []
  (let [app (express)]
    (.use app (serve-static "resources/public/js"))
    (.get app "/*" handle-request)
    (.listen app 3000 (fn []
                        (println "Server started on port 3000")))))

(set! *main-cli-fn* -main)
