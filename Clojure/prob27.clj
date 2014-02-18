(defn isPrime [n]
  (let [hi (int (Math/ceil (Math/sqrt n)))
        divs (drop-while #(not= 0 (mod n %)) (range 2 (inc hi)))]
    (or (= 0 (count divs)) (= 2 n))))

(map isPrime [2 3 5 7 11 13 17])
(map isPrime [4 6 8 10 9 12 15 18 20])

(def functions
  (for [a (range -999 1000)
        b (range -999 1000)]
    (fn [n]
      (+ (* n n) (* a n) b))))

(def f (nth functions (+ 1998000 1998 42)))

(map (comp isPrime f) (range 40))

