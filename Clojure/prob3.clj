(ns prob3
  (:use factors))

(defn maximum [list]
  (reduce max list))

(maximum (primeFactors 600851475143))
