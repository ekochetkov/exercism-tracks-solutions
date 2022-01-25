(ns pangram)

(defn pangram?
  [s]
  (= 26
   (->> s
      (filter #(Character/isLetter %))
      (map #(Character/toLowerCase %))
      (set)
      (count)))
)






