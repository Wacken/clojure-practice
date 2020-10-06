(ns test-midje.write-clojure-myself)

(defn my-map
  ([function coll]
   (reduce (fn [result c]
             (conj result (function c)))
           []
           coll))
  ([function coll1 coll2]
   (reduce (fn [result args]
             (conj result (function (first args) (second args))))
           []
           (partition 2 (interleave coll1 coll2)))))

(defn my-filter [function collection]
  (reduce (fn [result item]
            (if (function item)
              (conj result item)
              result))
          []
          collection))

(defn my-some [function collection]
  (reduce (fn [result item]
            (if (function item)
              (reduced true)))
          nil
          collection))

(defn my-comp
  ([f g]
   (fn [& args]
     (f (apply g args))))
  ([f g h]
   (fn [& args]
     (f (g (apply h args))))))

(defn the-comp [& funs]
  (fn [& args]
    (let [inner (apply (first funs) args)]
      (reduce  (fn [result cur-fun] (cur-fun result))
              inner
              (rest funs)))))

(defn my-comp-helper [inner & funcs]
  (if funcs
    (my-comp-helper
      ((first funcs) inner)
      (rest funcs))
    inner))
