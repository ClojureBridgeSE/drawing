(ns drawing.snowflakes
  (:require [quil.core :as q]
            [quil.middleware :as m]))

(defn setup []
  (q/smooth)
  {:background (q/load-image "images/rainbows.png")
   :snowflake (q/load-image "images/unicorn.png")
   :y-param 10})


(defn draw [state]
  #_(println "bg" (.height (:background state)) (.width (:background state)))
  (q/image (:background state) 0 0)
  (q/image (:snowflake state) 200 (:y-param state))
  (q/image (:snowflake state) 310 (:y-param state))
  (q/image (:snowflake state) 340 (:y-param state)))


(defn update [state]
  (if (>= (:y-param  state) (q/height))
    (assoc state :y-param  0)
    (clojure.core/update state :y-param #(+ (rand-int 4) %))))


(q/defsketch snowflakes
  :title "you can see lines"
  :size [600 401]
  :setup setup
  :update update
  :draw draw
  :features [:keep-on-top]
  :middleware [m/fun-mode])
