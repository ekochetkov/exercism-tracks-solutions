(ns space-age)

(def seconds-in-one-Earth-year {
   :Earth 31557600
   :Mars    (* 31557600   1.88081580)
   :Mercury (* 31557600   0.24084670)
   :Venus   (* 31557600   0.61519726)
   :Jupiter (* 31557600  11.86261500)
   :Saturn  (* 31557600  29.44749800)
   :Uranus  (* 31557600  84.01684600)
   :Neptune (* 31557600 164.79132000)})

(defn- round-with-precision
  "Round a double to the given precision (number of significant digits). https://stackoverflow.com/a/25098576"
  [precision d]
  (let [factor (Math/pow 10 precision)]
    (/ (Math/round (* d factor)) factor)))

(defn on-mercury [seconds]
  (round-with-precision 2
    (/ seconds (:Mercury seconds-in-one-Earth-year))))

(defn on-venus [seconds]
  (round-with-precision 2
    (/ seconds (:Venus seconds-in-one-Earth-year))))

(defn on-earth [seconds]
  (round-with-precision 2
    (/ seconds (:Earth seconds-in-one-Earth-year))))

(defn on-mars [seconds]
  (round-with-precision 2
    (/ seconds (:Mars seconds-in-one-Earth-year))))

(defn on-jupiter [seconds]
  (round-with-precision 2
    (/ seconds (:Jupiter seconds-in-one-Earth-year))))

(defn on-saturn [seconds]
  (round-with-precision 2
    (/ seconds (:Saturn seconds-in-one-Earth-year))))

(defn on-uranus [seconds]
  (round-with-precision 2
    (/ seconds (:Uranus seconds-in-one-Earth-year))))

(defn on-neptune [seconds]
  (round-with-precision 2
    (/ seconds (:Neptune seconds-in-one-Earth-year))))
