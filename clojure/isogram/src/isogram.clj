(ns isogram)

(defn isogram?
  ([s] (isogram? s #{}))
  ([s set-acc]
   (if (empty? s) true
     (let [f (Character/toLowerCase (first s)) r (rest s) ]
       (cond
         (not (Character/isLetter f)) (isogram? r set-acc)
         (contains? set-acc f) false
         :else (isogram? r (conj set-acc f)))))))
