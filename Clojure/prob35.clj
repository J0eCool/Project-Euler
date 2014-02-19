(ns prob35
  (:use primes))

(defn charToInt [c]
  (- (int c) (int \0)))

(defn numToDig [num]
  (map charToInt (str num)))

(defn digToNum [dig]
  (loop [lst dig
         acc 0]
    (if (= 0 (count lst))
           acc
           (recur
            (rest lst)
            (+ (* 10 acc) (first lst))))))

(defn rotations [n]
  (let [lst (numToDig n)]
    (for [i (range (count lst))]
      (let [split (split-at i lst)
            joined (concat (second split) (first split))]
        (digToNum joined)))))

(defn is-circular? [n]
  (reduce #(and %1 (isPrime %2)) true
          (rotations n)))

(is-circular? 12)
(is-circular? 197)

(count (filter is-circular? (range 1000000)))