(ns mirror.ui.components.browser-scenes
  (:require [portfolio.dumdom :as portfolio :refer-macros [defscene]]
            [portfolio.ui.components.browser :refer [Folder Package Unit]]))

(portfolio/configure-scenes
 {:title "Browser"})

(def package-illustration
  {:icon :portfolio.ui.icons/package
   :color "var(--highlight-color)"})

(defscene folder-title
  (Folder
   {:title "Layouts"
    :illustration {:icon :portfolio.ui.icons/folder}}))

(defscene package-list
  [:div
   (Package
    {:title "Some package"
     :illustration package-illustration
     :toggle {:icon :portfolio.ui.icons/caret-right
              :actions []}})
   (Package
    {:title "Another package"
     :illustration package-illustration
     :toggle {:icon :portfolio.ui.icons/caret-right
              :actions []}})])

(defscene open-package
  (Package
   {:title "Some scenes"
    :illustration package-illustration
    :toggle {:icon :portfolio.ui.icons/caret-down
             :actions []}
    :items [{:title "A scene"
             :context [:package]
             :illustration {:icon :portfolio.ui.icons/bookmark
                            :color "var(--browser-unit-icon-color)"}}]}))

(defscene selected-package
  (Package
   {:title "Some scenes"
    :selected? true
    :illustration package-illustration
    :toggle {:icon :portfolio.ui.icons/caret-down
             :actions []}
    :items [{:title "A scene"
             :context [:package]
             :illustration {:icon :portfolio.ui.icons/bookmark
                            :color "var(--browser-unit-icon-color)"}}]}))

(defscene open-folder
  (Folder
   {:title "Components"
    :kind :folder
    :illustration {:icon :portfolio.ui.icons/folder-open}
    :items [{:title "Some scenes"
             :kind :package
             :illustration package-illustration
             :context [:folder]
             :toggle {:icon :portfolio.ui.icons/caret-down
                      :actions []}
             :items [{:title "A scene"
                      :context [:folder :package]
                      :illustration {:icon :portfolio.ui.icons/bookmark
                                     :color "var(--browser-unit-icon-color)"}}]}]}))

(defscene nested-folder
  (Folder
   {:title "UI Kit"
    :illustration {:icon :portfolio.ui.icons/folder-open}
    :kind :folder
    :items
    [{:title "Process samples"
      :kind :folder
      :context [:folder]
      :illustration {:icon :portfolio.ui.icons/folder-open}
      :items [{:title "UI Malpractice: Don'ts"
               :kind :package
               :context [:folder :folder]
               :illustration package-illustration
               :toggle {:icon :portfolio.ui.icons/caret-down
                        :actions []}
               :items [{:title "Poor legibility"
                        :context [:folder :folder :package]
                        :selected? true
                        :illustration {:icon :portfolio.ui.icons/bookmark}}
                       {:title "Poor spacing"
                        :context [:folder :folder :package]
                        :illustration {:icon :portfolio.ui.icons/bookmark
                                       :color "var(--browser-unit-icon-color)"}}]}]}]}))

(defscene nested-package
  (Package
   {:title "UI Kit"
    :illustration package-illustration
    :kind :package
    :toggle {:icon :portfolio.ui.icons/caret-down}
    :items
    [{:title "Some scenes"
      :kind :package
      :context [:package]
      :illustration package-illustration
      :toggle {:icon :portfolio.ui.icons/caret-down
               :actions []}
      :items [{:title "A scene"
               :context [:package :package]
               :illustration {:icon :portfolio.ui.icons/bookmark
                              :color "var(--browser-unit-icon-color)"}}]}]}))

(defscene folder-in-package
  (Package
   {:title "UI Kit"
    :illustration package-illustration
    :kind :package
    :toggle {:icon :portfolio.ui.icons/caret-down}
    :items
    [{:title "A folder"
      :kind :folder
      :context [:package]
      :illustration {:icon :portfolio.ui.icons/folder-open}
      :items [{:title "A scene"
               :context [:package :folder]
               :illustration {:icon :portfolio.ui.icons/bookmark
                              :color "var(--browser-unit-icon-color)"}}]}]}))
