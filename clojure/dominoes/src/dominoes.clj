(ns dominoes)

(defn- chain-begin [chain]
  (-> (first chain) (get 0)))

(defn- chain-end [chain]
  (-> (last chain) (get 1)))
  
(defn- chain-begin-end-correct? [chain]
  (= (chain-begin chain) (chain-end chain)))

(defn- find-can-chain [ chain dominous ]
  (if (empty? dominous)
    (when (chain-begin-end-correct? chain) true)
    (reduce (fn [can-chain i] (or can-chain  
      (let [next-domino (dominous i)
            last-dominous (into (subvec dominous 0 i) (subvec dominous (inc i)))
            end-dots (chain-end chain)]
        (cond
          (empty? chain)
            (find-can-chain [ next-domino ] last-dominous)
          (= end-dots (first next-domino))
            (find-can-chain (conj chain next-domino) last-dominous)
          (= end-dots (second next-domino))
            (find-can-chain (conj chain (vec (reverse next-domino))) last-dominous )
      )))) false (range (count dominous)))))

(defn can-chain? [dominous]
  (some? (find-can-chain [] dominous)))
