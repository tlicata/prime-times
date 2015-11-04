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

(deftest test-get-first-n-primes
  (testing "getting the first n primes"
    (is (= [] (get-first-n-primes -1)))
    (is (= [] (get-first-n-primes 0)))
    (is (= [2] (get-first-n-primes 1)))
    (is (= [2 3] (get-first-n-primes 2)))
    (is (= [2 3 5 7 11] (get-first-n-primes 5)))))
