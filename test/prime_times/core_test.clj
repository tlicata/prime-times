(ns prime-times.core-test
  (:require [clojure.test :refer :all]
            [prime-times.core :refer :all]))

(deftest test-primes
  (testing "prime numbers"
    (is (not (prime? -1)))
    (is (not (prime? 0)))
    (is (not (prime? 1)))
    (is (prime? 2))
    (is (prime? 3))
    (is (not (prime? 4)))
    (is (prime? 5))
    (is (not (prime? 6)))
    (is (prime? 7))
    (is (prime? 115249))))
