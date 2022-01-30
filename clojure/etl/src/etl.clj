(ns etl
  (:require [clojure.string :refer [lower-case]]))

(defn transform
  [source]
  (reduce (fn[dict [k v]]
     (assoc dict k v)) {}  (mapcat (fn [ [point words] ]
        (mapcat #(assoc {} (lower-case %1)  %2) words (repeat point))) source))
  )
