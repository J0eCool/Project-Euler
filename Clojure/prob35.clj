(ns prob35
  (:use primes)
  (:use digits))

(defn is-circular? [n]
  (reduce #(and %1 (isPrime %2)) true
          (rotations n)))

(is-circular? 12)
(is-circular? 197)

(count (filter is-circular? (range 1000000)))
