(ns prob24
  (:use permute))

(defn fact [n]
  (loop [x n
         acc 1N]
    (if (<= x 1)
      acc
      (recur (dec x) (* x acc)))))

(fact 10) ;this is reasonable to do

(seq-contains? [2 3 4] 3)
(defn all [lst]
  (reduce #(and %1 %2) lst))
(defn any [lst]
  (reduce #(or %1 %2) lst))

(any (map (partial seq-contains? [5 6 7]) [1 2 3 5]))
(defn any-in [findIn toFind]
  (any (map (partial seq-contains? findIn) toFind)))
(any-in [1 2 3] [5 4])

(def digits (permute (range 10)))
(def sorted-digits (sort (map vec digits)))

(nth sorted-digits 999999)
