(ns prob41
  (:use primes)
  (:use permute))

(last (sort (filter isPrime (map digToNum (pandigitals 7)))))

(last (filter #(and (pandigital? %) (isPrime %)) (range 10000000)))
