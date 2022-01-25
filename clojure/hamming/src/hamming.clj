(ns hamming)

(defn distance [x y]
  (if (not= (count x) (count y)) nil
     (->>
       (map #(= %1 %2) x y)
       (filter false?)
       (count))))
