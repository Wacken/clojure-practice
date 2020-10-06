(ns test-midje.four-clojure)

(defn myFlatten-it [toFlatten output]
  (cond
    (empty? toFlatten)
    (if (coll? (last output))
      (recur (last output) (pop output))
      output)
    (coll? (last output))
    (recur toFlatten (conj (pop output) (first toFlatten)))
    :else
    (recur (rest toFlatten) (conj output (first toFlatten)))))

(defn myFlatten [toFlatten]
  (myFlatten-it toFlatten []))
