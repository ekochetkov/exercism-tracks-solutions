(ns run-length-encoding)

(defn run-length-encode
  "encodes a string with run-length-encoding"
  [plain-text]
  (reduce (fn [s acc]
    (str s (let [cnt (count acc)] (if (> cnt 1) cnt "")) (first acc)))
      "" (partition-by identity plain-text)))

(defn run-length-decode
  "decodes a run-length-encoded string"
  [cipher-text]
  (reduce (fn [ s [ _ cnts ch one-ch ] ]
            (str s (if (nil? cnts) one-ch
                      (apply str (repeat (Integer/parseInt cnts) ch)))) ) ""
          (re-seq #"(\d+)(.)|(.)" cipher-text)))

(defn run-length-encode-v1
  "encodes a string with run-length-encoding"
  [plain-text]
  (let [ [base last-acc] (reduce (fn [ [base acc last] ch]
          (cond
            (empty? acc)   [ base (list ch) ch ]
            (not= last ch) [ (conj base acc) (list ch) ch ]
            :else          [ base (conj acc ch) ch ] )) [ () () nil ] plain-text)
      accs (reverse (conj base last-acc))]
  (reduce (fn [s acc] (str s (let [cnt (count acc)] (if (> cnt 1) cnt "")) (first acc) )  ) "" accs)))
