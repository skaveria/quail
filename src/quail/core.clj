(ns quail.core
  (:gen-class)
  (:require [ring.adapter.jetty :as jetty]))

(defonce server* (atom nil))

(defn app [_request]
  {:status 200
   :headers {"content-type" "text/plain"}
   :body "hello from quail\n"})

(defn start-server!
  ([] (start-server! 8080))
  ([port]
   (when @server*
     (.stop @server*))
   (reset! server*
           (jetty/run-jetty app
                            {:port port
                             :join? false}))
   :started))

(defn stop-server! []
  (when @server*
    (.stop @server*)
    (reset! server* nil))
  :stopped)

(defn restart-server! []
  (stop-server!)
  (start-server!))

(defn -main [& _args]
  (jetty/run-jetty app {:port 8080 :join? true}))
