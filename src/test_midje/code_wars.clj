(ns test-midje.code-wars
  (:require [clojure.string :as s]))

(defn vector->string [in] (s/join (interpose " " in)))

(defn jaden-case [input]
  (vector->string
   (let [in (s/split
             input #" ")]
     (map #(str %1 %2)
          (map #(.toUpperCase (str (first %)))
               in)
          (map #(s/join (rest %))
               in)))))

(reduce + [1 2 3])

(fn fib [n]
  (cond (or (= n 1) (= n 2)) 1
        :else
        (+ (fib (- n 1)) (fib (- n 2)))))

(defn fibSeq [n]
  (map (fn fib [n]
         (cond (or (= n 1) (= n 2)) 1
               :else
               (+ (fib (- n 1)) (fib (- n 2)))))
       (map inc (take n (range)))))

(defn palindrome? [input]
  (= (reverse (reverse input)) (reverse input)))
