(ns crypto-square
  (:require [clojure.string :refer [lower-case join replace]]
            [clojure.math :refer [sqrt]]))

(defn normalize-plaintext [plain]
  (->> plain
       lower-case
       (filter #(or (Character/isLetter %)
                    (Character/isDigit %)))
       (apply str)))

(defn square-size [normalized-text]
  (-> normalized-text count dec sqrt int inc))

(defn plaintext-segments [plaintext]
  (let [normalized (normalize-plaintext plaintext)
        size (square-size normalized)]
    (->> normalized         
         (partition-all size)
         (map #(apply str %)))))

(defn cipher-segments [plaintext-segments]
  (let [size (-> plaintext-segments first count)]
    (->> plaintext-segments
         (map #(take size (concat % (repeat " "))))
         (apply (partial map list))
         (map #(apply str %)))))
    
(defn ciphertext [plaintext]
  (-> plaintext
      plaintext-segments
      cipher-segments
      join
      (replace " " "")))

(defn normalize-ciphertext [plaintext]
  (->> plaintext
       plaintext-segments
       cipher-segments
       (join " ")))
