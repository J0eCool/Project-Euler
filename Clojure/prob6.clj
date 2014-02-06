(ns prob6)

(defn squared [x] (* x x))

(defn sum-square [n]
  (reduce + (map squared (range 1 (inc n)))))
(defn square-sum [n]
  (squared (reduce + (range 1 (inc n)))))

(defn diff-square-sum [n]
  (- (square-sum n) (sum-square n)))

(diff-square-sum 100)
