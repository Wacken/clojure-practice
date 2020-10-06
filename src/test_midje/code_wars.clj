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
