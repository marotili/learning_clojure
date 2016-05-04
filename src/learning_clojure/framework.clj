(ns learning-clojure.framework
  (:require [quil.core :as q]
            [quil.middleware :as m]))

(defn setup [initialize]
  (q/frame-rate 60)
  (q/background 200)
  (initialize))

(defmacro sketch
  [initialize draw update key-pressed]
  `(q/defsketch ~'example-sketch
                :title "Example"
                :setup (partial setup ~initialize)
                :draw ~draw
                :update ~update
                :middleware [m/fun-mode]
                :key-pressed ~key-pressed
                :size [600 400]))
