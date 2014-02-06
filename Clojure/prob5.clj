(ns prob5
  (:use factors))

(defn factorial [n]
  (if (< n 2) n
    (* n (factorial (dec n)))))

(map factorial (range 21))

(factors 12)
(primeFactors (factorial 15))
