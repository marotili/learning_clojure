(ns learning-clojure.core
  (:gen-class)
  (:require [learning-clojure.framework :refer :all]
            [quil.core :as q]))

(defn function-name [x] x)

(defn move-random-pos [position]
  (let [x (first position)
        y (second position)]
    [(inc x) (inc y)]))

(defn initialize-sketch
  []
  (q/background 0)
  {:text "Hallo Welt!"
   :pos  [0 100]})

(defn update-sketch
  [old-state]
  (println old-state)

  (let [new-state (update old-state :pos move-random-pos)]
    new-state)
  old-state
  )

(defn draw-sketch
  [old-state]
  (q/clear)
  (let [text (:text old-state)
        pos (:pos old-state)
        x (first pos)
        y (second pos)]
    (q/text text x y)))

(defn key-pressed-sketch
  [old-state key-dict]
  (case (:key key-dict)
    :a (update old-state :pos move-random-pos)
    :d (update old-state :pos move-random-pos)
    :w (update old-state :pos move-random-pos)
    :s (update old-state :pos move-random-pos)
    old-state))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (sketch initialize-sketch draw-sketch update-sketch key-pressed-sketch))
