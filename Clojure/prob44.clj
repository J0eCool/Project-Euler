(def pentagonals
  (map (fn [n] (/ (* n (- (* 3 n) 1)) 2)) (range)))

(defn approx [x y]
  (> 0.000001
     (Math/abs (- x y))))

(defn is-pent? [n]
  (let [p (/ (+ (Math/sqrt (+ 1 (* n 24))) 1) 6)]
    (approx p (float (int p)))))

(loop [j 1]
  (let [pj (nth pentagonals j)
        pairs (for [k (range 1 (inc j))]
                (let [pk (nth pentagonals k)]
                  {:j j :k k :pj pj :pk pk
                   :sum (+ pk pj)
                   :diff (- pj pk)}))
        pent-pairs (filter
                    #(and (is-pent? (:sum %))
                          (is-pent? (:diff %))
                          )
                    pairs)]
    (if (not= 0 (count pent-pairs))
      pent-pairs
      (recur (inc j)))))
