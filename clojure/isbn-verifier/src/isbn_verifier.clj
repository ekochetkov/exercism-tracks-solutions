(ns isbn-verifier)

(def ch->int
  { \0 0 \1 1 \2 2 \3 3 \4 4 \5 5 \6 6 \7 7 \8 8 \9 9 \X 10 })

(defn isbn? [isbn]
    (if (nil? (re-matches #"(\d-\d{3}-\d{5}-[\dX])|(\d{9}[\dX])" isbn))
        false
        (->> isbn
             (remove #(= % \-))
             (map ch->int)
             (map * (reverse (range 1 11)))
             (reduce +)
             (#(rem % 11))
             zero?)))
