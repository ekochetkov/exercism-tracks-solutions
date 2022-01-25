(ns robot-name)

(def used-robot-names (atom #{}))

(defn- generate-name
  []
  (let [first-char-index  (+ 65 (rand-int 25))
        second-char-index (+ 65 (rand-int 25))
        number (rand-int 1000)]
        (format "%c%c%03d"
            (char first-char-index)
            (char second-char-index)
            number)
        ))

(defn- new-name
  []
  (let [new-robot-name (generate-name)]
    (if (contains? @used-robot-names new-robot-name)
      (recur)
      (do
        (swap! used-robot-names conj new-robot-name)
        new-robot-name
       ))))

(defn robot
  []
  (let [new-robot (atom "")]
    (reset! new-robot (new-name))
    new-robot
  ))

  
(defn robot-name
  [robot]
  @robot)

(defn reset-name
  [robot]
  (reset! robot (new-name)))
