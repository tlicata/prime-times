(ns prime-times.core
  (:require [clojure.math.numeric-tower :refer [exact-integer-sqrt]]
            [clojure.pprint :refer [print-table]]))

(defn prime? [k]
  (let [sqrt (first (exact-integer-sqrt k))]
    (nil? (some #(= 0 (mod k %)) (range 2 (inc sqrt))))))

(defn get-first-n-primes [n]
  (take n (filter prime? (drop 2 (range)))))

(defn -main
  "Print out a multiplication table of the first 10 prime numbers."
  []
  (let [star "*"
        primes (get-first-n-primes 10)
        columns (concat [star] primes)
        rows (map #(merge {star %} (zipmap primes (map (partial * %) primes))) primes)]
    (print-table columns rows)))
