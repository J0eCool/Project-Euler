(ns digits)

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
