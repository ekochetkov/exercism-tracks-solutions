(ns atbash-cipher
  (:require [clojure.string :as s]))

(defn encode [plain]
  (let [alphabet (map char (range (int \a)
                                  (inc (int \z))))
        cipher   (zipmap alphabet (reverse alphabet))]
  (->> plain
       s/lower-case
       (filter #(or (Character/isLetter %)
                    (Character/isDigit %)))
       (map #(get cipher % %))
       (partition 5 5 '(""))
       (map #(apply str %))
       (s/join " "))))
