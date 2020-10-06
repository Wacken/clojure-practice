(ns test-midje.four-clojure-test
  (:require [midje.sweet :refer :all]
            [test-midje.four-clojure :refer :all]))

(facts "Flattening without flatten"
       (fact "No Element"
             (myFlatten []) => (flatten [])
             (myFlatten '()) => (flatten '())
             (myFlatten {}) => (flatten {})
             (myFlatten #{}) => (flatten #{}))
       (fact "One Element"
             (myFlatten [1]) => (flatten [1])
             (myFlatten ["a"]) => (flatten ["a"])
             (myFlatten [:a]) => (flatten [:a]))
       (fact "More Elements"
             (myFlatten [1 2]) => (flatten [1 2])
             (myFlatten [1 2 3]) => (flatten [1 2 3])
             (myFlatten '(1 2 3)) => (flatten '(1 2 3)))
       (fact "One Collection"
             (myFlatten [[1]]) => (flatten [[1]]))
       (fact "Multiple and One Collection"
             (myFlatten [1 [1] 1]) => (flatten [1 [1] 1])
             (myFlatten [[1] 1]) => (flatten [[1] 1])
             (myFlatten [1 [1]]) => (flatten [1 [1]]))
       (fact "Nested Collection"
             (myFlatten [[[[1]]]]) => (flatten [[[1]]])
             ;;(myFlatten '((1 2) 3 [4 [5 6]])) => (flatten '((1 2) 3 [4 [5 6]]))
             (myFlatten [4 [5 6 [1 2 3]]]) => (flatten [4 [5 6 [1 2 3]]])
             ;(myFlatten [[4 5] 6]) => (flatten [[4 5] 6])
             ))