(ns site.tools
  (:require [reagent.code :as reagent]))

(enable-console-print!)

(defn template []
  [:html
   [:head
    [:meta {:charset "utf-8"}]
    [:meta {:name "viewport"
            :content "width=device-width, initial-scale=1.0"}]]
   [:body
    [:div#app
     [:h1 "Server Rendering!!"]]]])

(defn ^:export render-page [path]
  (reagent/render-to-static-markup [template]))
