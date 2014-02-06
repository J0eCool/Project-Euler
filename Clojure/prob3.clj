(defn divisibleBy [x n] (= (mod x n) 0))
(defn factors [n]
  (filter (partial divisibleBy n) (range 2 (Math/ceil (Math/sqrt n)))))
(defn isPrime [n]
  (= (factors n) []))
(defn primeFactors [n]
  (filter isPrime (factors n)))
(def primes (filter isPrime (range)))

(defn maximum [list]
  (reduce max list))

(maximum (primeFactors 600851475143))
