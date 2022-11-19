(ns pig-latin
  (:require [clojure.string :refer [split join]]))

(defn translate-word [word]
  (str (cond
    (re-matches #"^(yt|xr|[aeiou]).+$" word)
      word

    (re-matches #"^[A-z]y$" word)
      (str "y" (first word))

    (re-matches #"(squ|thr|sch).+$" word)
      (str (subs word 3) (subs word 0 3))

   (re-matches #"^(ch|qu|th|rh).+$" word)
      (str (subs word 2) (subs word 0 2))

   (re-matches #"^[pkyxqfr].+$" word)
      (str (subs word 1) (first word))) "ay"))

(defn translate [phrase]
  (->> (split phrase #" ")
       (map translate-word)
       (join " ")))
