(ns learning-clojure.core
  (:gen-class)
  (:require [learning-clojure.framework :refer :all]
            [quil.core :as q]))

(defn initialize-sketch
  []
  0)

(defn update-sketch
  [old-state]
  (q/background old-state)
  (mod (inc old-state) 255))

(defn draw-sketch
  [old-state])

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (sketch initialize-sketch draw-sketch update-sketch))
