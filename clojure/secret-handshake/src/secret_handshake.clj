(ns secret-handshake)

(defn bool-bit-and [a b]
  (if (zero? (bit-and a b)) false true))

(defn commands [com]
  (cond-> []
    (bool-bit-and 2r00001 com) (conj "wink")
    (bool-bit-and 2r00010 com) (conj "double blink")
    (bool-bit-and 2r00100 com) (conj "close your eyes")
    (bool-bit-and 2r01000 com) (conj "jump")
    (bool-bit-and 2r10000 com) reverse))
