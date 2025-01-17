(ns portfolio.ui.components.document
  (:require [dumdom.core :as d]
            [markdown.core :as md]
            [portfolio.ui.components.markdown :refer [Markdown]]))

(d/defcomponent Document [{:keys [title sections]}]
  [:div.document.dark {:style {:padding 20}}
   [:h1.h1 title]
   (for [section sections]
     (case (:kind section)
       :markdown (Markdown (update section :markdown md/md->html))))])
