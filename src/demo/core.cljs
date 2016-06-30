(ns demo.core
  (:require [reagent.core :refer [atom]]
            [secretary.core :as secretary :refer-macros [defroute]]))

(def current-page (atom nil))

(defn home-page []
  [:div [:h1 "Home Page"]])

(defn app-view []
  [:div [@current-page]])

(secretary/set-config! :prefix "/")

(defroute "/" []
  (.log js/console "home page")
  (reset! current-page home-page))

(reset! current-page home-page)
