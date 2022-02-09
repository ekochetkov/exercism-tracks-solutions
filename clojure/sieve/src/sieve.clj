(ns sieve)

(defn sieve
  ([to-n] (sieve to-n (range 2 (inc to-n)) 2))
  ([to-n numbers n]
    (cond
      (> (* n 2) to-n) (remove nil? numbers)
      (nil? (nth numbers (- n 2))) (recur to-n numbers (inc n))
      :else (recur to-n (map #(cond
                                (nil? %) %
                                (= % n) n
                                (zero? (rem % n)) nil
                                :else %) numbers) (inc n)))))
