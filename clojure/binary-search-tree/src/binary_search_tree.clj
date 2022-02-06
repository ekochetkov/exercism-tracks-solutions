(ns binary-search-tree)

(defn value [node] (:v node))

(defn singleton [v] {:l nil :v v :r nil})

(defn insert
  ([v node]
    (if (<= v (value node))
      (insert v node :l)
      (insert v node :r)))
  ([v node dir]
    (if (nil? (dir node))
      (assoc node dir (singleton v))
      (assoc node dir (insert v (dir node))))))

(defn left  [node] (:l node))
(defn right [node] (:r node))

(defn to-list [tree]
  (if (map? tree)
    (concat
     (to-list (left tree))
     [ (value tree) ]
     (to-list (right tree)))
  (value tree)))

(defn from-list
  [lst]
  (reduce (fn [tree v] (insert v tree))
    (singleton (first lst)) (rest lst)))

