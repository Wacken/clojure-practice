(ns test-midje.write-clojure-myself-test
  (:require [midje.sweet :refer [=> facts fact]]
            [test-midje.write-clojure-myself :refer [my-map my-filter the-comp my-some]]))

(facts "map with reduce"
       (fact "Two collection"
             (my-map + [1 1] [1 1]) => (map + [1 1] [1 1]))
       (fact "One collection"
             (my-map inc [1 2]) => (map inc [1 2])))

(facts "filter with reduce"
       (fact "equal"
             (my-filter #(= % 0) [1 0 2]) => (filter #(= % 0) [])))

(facts "some with reduce"
       (fact "nil if not there"
             (my-some #(= % 0) [1]) => (some #(= % 0) [1]))
       (fact "true if there"
             (my-some #(= % 0) [0]) => (some #(= % 0) [0]))
       (fact "true if there more"
             (my-some #(= % 0) [0 1]) => (some #(= % 0) [0 1])))

(facts
 (fact "two functions"
       ((the-comp inc inc) 0) => 2)
 (fact "more functions"
       ((the-comp inc inc inc) 0) => 3
       ((the-comp inc inc inc inc inc dec) 0) => 4))
