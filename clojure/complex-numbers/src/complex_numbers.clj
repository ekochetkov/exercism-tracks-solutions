(ns complex-numbers)

(defn real
  "Get real part of complex number"
  [[a b]]
  a
)

(defn imaginary
  "Get imaginary part of complex number"
  [[a b]]
  b
)

(defn abs
  "Get absolute value of complex number"
  [[a b]]
  (Math/sqrt (+ (* a a) (* b b)))
)

(defn conjugate
  "Get conjugate of the complex number"
  [[a b]]
  [a (* -1 b)]
)

(defn add
  "Add two complex numbers"
  [[a b] [c d]]
  [(+ a c) (+ b d)]
)

(defn sub
  "Substract two complex numbers"
  [[a b] [c d]]
  [(- a c) (- b d)]
)

(defn mul
  "Multiplication of two complex numbers"
  [[a b] [c d]]
  [
   (- (* a c) (* b d))
   (+ (* b c) (* a d))]
)

(defn div
  "Dividing of two complex numbers"
  [[a b] [c d]]
  (let [sum-c-d-pow-2 (+ (* c c) (* d d))]
  [
   (double (/ (+ (* a c) (* b d)) sum-c-d-pow-2 ))
   (double (/ (- (* b c) (* a d)) sum-c-d-pow-2 ))])
  )
