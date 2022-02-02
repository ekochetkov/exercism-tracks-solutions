(ns flatten-array)

(defn flatten [arr]
  (remove nil? (mapcat #(if (coll? %)
     (flatten %) (list %)) arr)))
