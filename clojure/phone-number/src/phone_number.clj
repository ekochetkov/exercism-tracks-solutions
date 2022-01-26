(ns phone-number)

(defn number
  "To plain and validate number-string"
  [num-string]
  (let [plain-raw-number (apply str (filter #(Character/isDigit %) num-string))
        plain-number (re-matches #"1*([2-9]\d{2}[2-9]\d{2}\d{4})" plain-raw-number)]
    (if (empty? plain-number) "0000000000"
        (get plain-number 1))))

(defn area-code
  "Get area-code of num-string"
  [num-string]
  (subs (number num-string) 0 3))
      
(defn pretty-print
  "Pretty-print for num-string"
  [num-string]
  (let [plain-number (number num-string)]
  (format "(%s) %s-%s"
    (subs plain-number 0 3)
    (subs plain-number 3 6)
    (subs plain-number 6))))
