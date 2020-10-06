(ns test-midje.code-wars-test
  (:require [midje.sweet :refer :all]
            [clojure.string :as s]
            [test-midje.code-wars :refer :all]))
(facts
 (fact
  (jaden-case "How can mirrors be real if our eyes aren't real") => "How Can Mirrors Be Real If Our Eyes Aren't Real"))
