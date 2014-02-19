(def pentagonals
  (map (fn [n] (/ (* n (- (* 3 n) 1)) 2)) (range)))

(defn is-pent? [n]
  (and
   (> n 0)
   (= n (first (drop-while (partial > n) pentagonals)))))

(loop [j 1]
  (let [pj (nth pentagonals j)
        pairs (for [k (range 1 (inc j))]
                (let [pk (nth pentagonals k)]
                  {:j j :k k :pj pj :pk pk
                   :sum (+ pk pj)
                   :diff (- pj pk)}))
        pent-pairs (filter
                    #(and (is-pent? (:sum %))
                          (is-pent? (:diff %)))
                    pairs)]
    (if (not= 0 (count pent-pairs))
      pent-pairs
      (recur (inc j)))))
