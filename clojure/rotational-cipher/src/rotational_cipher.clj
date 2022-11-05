(ns rotational-cipher)

(defn rotate-letter [c rot]
  (let [base (if (Character/isUpperCase c)
               (int \A) (int \a))
        pos-rot (if (neg? rot)
                  (+ 26 (rem rot 26)) rot)        
        current (- (int c) base)
        delta (rem (+ current pos-rot) 26)]
     (char (+ base delta))))

(defn rotate [s rot]
  (->> s
       (map #(cond-> %
               (Character/isLetter %) (rotate-letter rot)))
       (apply str)))
