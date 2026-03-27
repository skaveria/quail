(ns user
  (:require [quail.core :as quail]))

(defn go []
  (quail/start-server!))

(defn halt []
  (quail/stop-server!))

(defn reset []
  (quail/restart-server!))
