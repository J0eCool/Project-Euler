(def triangles
  (map (fn [n] (/ (* n (+ n 1)) 2)) (range)))
(def pentagonals
  (map (fn [n] (/ (* n (- (* 3 n) 1)) 2)) (range)))
(def hexagonals
  (map (fn [n] (* n (- (* 2 n) 1))) (range)))


(take 10 triangles)
(take 10 pentagonals)
(take 10 hexagonals)

(defn is-in? [n lst]
  (= n (first (drop-while (partial > n) lst))))

(defn is-all [n]
  (and
   (is-in? n triangles)
   (is-in? n pentagonals)
   (is-in? n hexagonals)))

(loop [tri (drop-while (partial >= 40755) triangles)
       pent (drop-while (partial >= 40755) pentagonals)
       hex (drop-while (partial >= 40755) hexagonals)]
  (let [t (first tri)
        pen (if (> t (first pent)) (rest pent) pent)
        he (if (> t (first hex)) (rest hex) hex)]
    (if (= t (first pen) (first he))
      t
      (recur (rest tri) pen he))))

