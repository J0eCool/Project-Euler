(ns digits)

(defn seq-contains? [lst v]
  (< 0 (count (filter (partial = v) lst))))

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
