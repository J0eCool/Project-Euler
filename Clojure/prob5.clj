(ns prob5)

(def primes
  (let [getPrime
        (fn [n]
          (case n
            0 2
            (let
              [soFar (take n primes)
               find-next
               (fn [v]
                 (let [isPrime (reduce #(and %1 %2) (map #(= 0 (v mod %1)) soFar))]
                   (if isPrime v (recur (inc v)))))]
              soFar)))]
    (map getPrime (range))))

(take 1 primes)
(getPrime 4)
(take 12 (range 4))
(last '(2))
(take 3 primes)

(getPrime 1)

(take 1 primes)

primes

(take 2 (map getPrime (range)))
