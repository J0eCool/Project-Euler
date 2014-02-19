(ns prob30
  (:use digits))

(defn sumFifthPowDig [n]
  (int (reduce + (map #(Math/pow % 5) (numToDig n)))))

(= 1634 (sumFifthPowDig 1634))

(def upperBound (* 10 (Math/pow 9 5)))
upperBound

(reduce + (filter #(= % (sumFifthPowDig %)) (range 2 upperBound)))
