(ns prob46
  (:use primes))

(defn odd-composite? [n]
  (and (> n 1) (odd? n) (not (isPrime n))))

(def primes (filter isPrime (range)))
(def squares (map #(* % %) (range)))
(def odd-composites (filter odd-composite? (range)))

(nth primes 1008)
(take 100 squares)
(take 400 odd-composites)

(defn goldbach? [n]
  (let [prs (take-while (partial > n) primes)
        sqs (take-while (partial > n) squares)
        sums (for [p prs
                   s sqs]
               (+ p (* 2 s)))]
  (< 0 (count (filter (partial = n) sums)))))

(take 1 (drop-while goldbach? odd-composites))
