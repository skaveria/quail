(defproject quail "0.1.0-SNAPSHOT"
  :description "Quail webserver"
  :dependencies [[org.clojure/clojure "1.12.2"]
                 [ring/ring-core "1.15.0"]
                 [ring/ring-jetty-adapter "1.15.0"]]
  :main quail.core
  :profiles {:dev {:source-paths ["dev"]}})
