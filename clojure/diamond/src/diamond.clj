(ns diamond)

(defn- take-without-last-and-reverse [coll]
  (reverse (take (dec (count coll)) coll)))

(defn diamond
  [letter]
  (let [
        letters (for [ ch (range (int \A) (inc (int letter))) ] (char ch) )
        len (count letters)
        head (mapv (fn [l b]
          (let [ left (concat
                       (repeat b \space)
                       (list l)
                       (repeat (- len b 1) \space)) ]
             (apply str (concat left (take-without-last-and-reverse left))))
          ) letters (reverse (range len))) ]
       (concat head (take-without-last-and-reverse head))
      ))
