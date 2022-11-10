(ns portfolio.dom
  (:require [portfolio.scene :as scene]))

(defmacro defscene [id & opts]
  `(portfolio.data/register-scene!
    (portfolio.dom/create-scene
     ~(scene/get-options-map id opts))))