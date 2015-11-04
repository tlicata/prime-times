(ns prime-times.core
  (:require [clojure.math.numeric-tower :refer [exact-integer-sqrt]]
            [clojure.pprint :refer [print-table]]))

(defn prime? [k]
  (if (> k 1)
    (let [sqrt (first (exact-integer-sqrt k))]
      (nil? (some #(= 0 (mod k %)) (range 2 (inc sqrt)))))
    false))

(defn get-first-n-primes [n]
  (take n (filter prime? (range))))

(defn -main
  "Print out a multiplication table of the first 10 prime numbers."
  [& args]
  (let [star "*"
        n (try (Integer/parseInt (first args)) (catch Exception e 10))
        primes (get-first-n-primes n)
        columns (concat [star] primes)
        rows (map #(merge {star %} (zipmap primes (map (partial * %) primes))) primes)]
    (print-table columns rows)))
