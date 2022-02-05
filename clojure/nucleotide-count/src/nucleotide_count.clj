(ns nucleotide-count)

(defn count-of-nucleotide-in-strand
  [nucleotide strand]
  (if (some #(= nucleotide %) '( \A \T \C \G ))
    (count (filter #(= nucleotide %) strand))
    (throw (Exception.)))
)

(defn nucleotide-counts
  [strand]
  (merge {\A 0 \T 0 \C 0 \G 0}
         (frequencies strand)))
