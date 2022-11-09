(ns portfolio.html
  (:require [portfolio.scene :as scene]))

(defmacro defscene [id & opts]
  `(portfolio.data/register-scene!
    (portfolio.html/create-scene
     ~(scene/get-options-map id opts))))
