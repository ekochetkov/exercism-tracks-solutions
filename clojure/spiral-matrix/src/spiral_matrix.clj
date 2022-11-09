(ns spiral-matrix)

(defn proection [matrix [[start-x start-y delta-x delta-y] values]]
  (loop [m matrix
         x start-x
         y start-y
         v values]
    (if (empty? v)
      m
      (let [new-m (assoc-in m [y x] (first v))]
        (recur new-m
               (+ x delta-x)
               (+ y delta-y)
               (rest v))))))

(defn spiral [n]
  (let [matrix  (vec (repeat n (vec (repeat n nil))))
        numbers (map inc (range (* n n)))]
    (loop [n n x 0 y 0 m matrix v numbers]
      (if (<= n 0)
        m
        (let [dec-n (dec n)
              new-m (->> (map vector
                              (list [         x            y  1  0]
                                    [(+ x dec-n)           y  0  1]
                                    [(+ x dec-n) (+ y dec-n) -1  0]
                                    [         x  (+ y dec-n)  0 -1])               
                              (if (zero? dec-n)
                                (list v)
                                (partition dec-n v)))
                         (reduce proection m))]
          (recur (- n 2) (inc x) (inc y) new-m (drop (* 4 dec-n) v)))))))
