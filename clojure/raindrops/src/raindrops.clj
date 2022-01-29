(ns raindrops)

(defn convert
  [number]
  (let [factors (str
          (when (zero? (rem number 3)) "Pling")
          (when (zero? (rem number 5)) "Plang")
          (when (zero? (rem number 7)) "Plong") )]
    (if (empty? factors) (str number)
        factors))
)
