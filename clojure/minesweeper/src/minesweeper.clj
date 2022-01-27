(ns minesweeper
    (:require [clojure.string :as cstr :only (join split index-of)]))

(def line-separator (System/getProperty "line.separator"))

(defn index->pos
  "Convert index to positon"
  [index row-len]
  (let [y (int (/ index row-len))
        x (- index (* row-len y) )]
    [y x]))

(defn pos->index
  "Conver postiton to index"
  [position row-len]
  (+ (* (position 0) row-len) (position 1)))

(defn draw
  "Add the mine counts to a completed Minesweeper board"
  [board]
  (apply str
    (let [row-len (if-let [p (cstr/index-of board line-separator)]
                (+ p (count line-separator)) (count board))
          relative-positions
            '( [-1 -1] [0 -1] [1 -1]
               [-1  0]        [1  0]
               [-1  1] [0  1] [1  1] )]
      (map (fn [index]
        (if (= (get board index) \space )
           (let [a-pos (index->pos index row-len)
                 sum (reduce + (map (fn [r-pos]
                    (let [r-index (pos->index (mapv + a-pos r-pos) row-len)]
                      (if (= \* (get board r-index)) 1 0) )) relative-positions))]
                 (if (zero? sum) \space (str sum))
             )
        (get board index))) 
        (range (count board)) ))))

