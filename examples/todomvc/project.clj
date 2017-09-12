(defproject todomvc-re-frame "0.10.1"
  :dependencies [[org.clojure/clojure        "1.8.0"]
                 [org.clojure/clojurescript  "1.9.908"]
                 [reagent "0.7.0"]
                 [re-frame "0.10.1"]
                 [binaryage/devtools "0.9.4"]
                 [secretary "1.2.3"]]


  :plugins [[lein-cljsbuild "1.1.5"]
            [lein-figwheel  "0.5.13"]]

  :hooks [leiningen.cljsbuild]

  :profiles {:dev  {:dependencies [[day8.re-frame/trace "0.1.7-SNAPSHOT"]]
                    :cljsbuild    {:builds {:client {:compiler {:asset-path           "js"
                                                                :optimizations        :none
                                                                :source-map           true
                                                                :closure-defines      {"re_frame.trace.trace_enabled_QMARK_" true}
                                                                :preloads             [day8.re-frame.trace.preload]
                                                                :source-map-timestamp true
                                                                :main                 "todomvc.core"}
                                                     :figwheel {:on-jsload "todomvc.core/main"}}}}}

             :prod {:cljsbuild
                    {:builds {:client {:compiler {:optimizations :advanced
                                                  :elide-asserts true
                                                  :pretty-print  false}}}}}}

  :figwheel {:server-port 3450
             :repl        true}


  :clean-targets ^{:protect false} ["resources/public/js" "target"]

  :cljsbuild {:builds {:client {:source-paths ["src" "../../src"]
                                :compiler     {:output-dir "resources/public/js"
                                               :output-to  "resources/public/js/client.js"}}}})
