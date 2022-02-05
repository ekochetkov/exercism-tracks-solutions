(ns acronym)

(defn acronym [s]
  (if (empty? s) ""
  (let [words (re-seq #"[A-Z]+[a-z]+|[A-z]+" s) first-word (first words) ]
    (if (every? #(Character/isUpperCase %) first-word)
      first-word
      (reduce #(str %1 (Character/toUpperCase (get %2 0) ) ) "" words)))))
