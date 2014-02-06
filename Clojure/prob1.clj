(ns prob1)

(defn multipleOf [x n] (= (mod x n) 0))

(defn threeOrFive [x] (or (multipleOf x 3) (multipleOf x 5)))

(defn threeFiveSum [n]
  (reduce + (filter threeOrFive (range n))))

(threeFiveSum 1000)
