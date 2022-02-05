(ns collatz-conjecture)

(defn collatz
  ([num] (collatz num 0))
  ([num steps]
   (cond
     (or (zero? num) (neg? num)) (throw (Exception.))
     (=   1 num) steps
     (even? num) (recur (/ num 2) (inc steps))
     (odd?  num) (recur (+ 1 (* 3 num)) (inc steps)))))
