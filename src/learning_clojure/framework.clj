(ns learning-clojure.framework
  (:require [quil.core :as q]
            [quil.middleware :as m]))

(defn setup [initialize]
  (q/frame-rate 60)
  (q/background 200)
  (initialize))

(defmacro sketch
  [initialize draw update]
  `(q/defsketch ~'example-sketch
                :title "Example"
                :setup (partial setup ~initialize)
                :draw ~draw
                :update ~update
                :middleware [m/fun-mode]
                :size [600 400]))
