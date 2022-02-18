(ns perfect-numbers)

(defn- sum-of-factors [number] 
  (reduce + (filter #(zero? (rem number %))
    (reverse (range 1 (dec number))))))

(defn classify
  [number]
  (if (neg? number) (throw (IllegalArgumentException.))
      (let [sum (sum-of-factors number)]
        (cond
          (= sum number) :perfect
          (< sum number) :deficient
          :else          :abundant))))
