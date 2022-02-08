(ns binary-search)

(defn search-for
  ([v a]
   (if (or (< v (first a)) (> v (last a)))
     (throw (new Exception "not found"))
   (search-for v a -1 (count a))))
  ([v a l r]
     (let [m (int (/ (+ l r) 2)) ma (nth a m)]
       (cond
         (= ma v) m
         (> v ma) (recur v a (inc m) r)
         :else    (recur v a l (dec m))))))

(defn middle [v]
  (int (/ (count v) 2)))

