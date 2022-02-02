(ns luhn)

(def char-digit->int
  {\0 0 \1 1 \2 2 \3 3 \4 4 \5 5 \6 6 \7 7 \8 8 \9 9})

(defn luhn-sum [cn]
  (->> cn
     (reverse)  
     (map char-digit->int)
     (map vector (range (count cn)))
     (map (fn [ [i v] ] (if (even? i) v
         (let [m (* v 2)] (if (< m 10) m (- m 9))))))
     (reduce +)))

(defn valid? [card-number]
  (let [cn (remove #(= \space %) card-number)]
    (and
     (> (count cn) 1)
     (every? #(Character/isDigit %) cn)
     (zero? (rem (luhn-sum cn) 10)))))
