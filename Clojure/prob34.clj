(ns prob34
  (:use digits))

(defn fact [n]
  (loop [x n
         acc 1]
    (if (< x 2)
      acc
      (recur (dec x) (* x acc)))))

(defn fact-dig-sum [n]
  (reduce + (map fact (numToDig n))))

(defn eq-sum-fact [n]
  (= n (fact-dig-sum n)))

;upper bound is 10*(9!), after which no additional
;single factorial digits can keep up with multiplying the number by 10
(filter eq-sum-fact (range 3 (* 10 (fact 9))))
