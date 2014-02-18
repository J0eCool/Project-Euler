(defn fact [n]
  (loop [x n
         acc 1N]
    (if (<= x 1)
      acc
      (recur (dec x) (* x acc)))))

(fact 10) ;this is reasonable to do

(defn seq-contains? [lst v]
  (< 0 (count (filter (partial = v) lst))))

(seq-contains? [2 3 4] 3)
(defn all [lst]
  (reduce #(and %1 %2) lst))
(defn any [lst]
  (reduce #(or %1 %2) lst))

(any (map (partial seq-contains? [5 6 7]) [1 2 3 5]))
(defn any-in [findIn toFind]
  (any (map (partial seq-contains? findIn) toFind)))
(any-in [1 2 3] [5 4])

(defn permute [lst]
  (loop [poss [[]]
         c (count lst)]
    (if (= 0 c)
      poss
      (let [nextStep (for [p poss
                           i (filter (comp
                                      not
                                      (partial seq-contains? p))
                                     lst)]
                       (cons i p))]
        (recur nextStep (dec c))))))

(def digits (permute (range 10)))
(def sorted-digits (sort (map vec digits)))

(nth sorted-digits 999999)
