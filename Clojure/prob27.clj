(defn isPrime [n]
  (cond (= n 2) true
        (< n 2) false
        :else (let [hi (int (Math/ceil (Math/sqrt n)))
                    divs (drop-while #(not= 0 (mod n %)) (range 2 (inc hi)))]
                (= 0 (count divs)))))

(map isPrime [2 3 5 7 11 13 17])
(map isPrime [4 6 8 10 9 12 15 18 20])

(def functions
  (for [a (range -999 1000)
        b (range -999 1000)]
    {:func (fn [n] (+ (* n n) (* a n) b))
     :a a
     :b b}))

(def f (nth functions (+ 1998000 1998 42)))
(def f_n_41 (:func (first (filter #(and (= 1 (:a %)) (= 41 (:b %))) functions))))

(defn consecutive-primes [func] (take-while isPrime (map func (range))))

(consecutive-primes f_n_41)

(let [counts (map (fn [f] {:item f :count (count (consecutive-primes (:func f)))}) functions)
      max-item (apply max-key :count counts)
      item (:item max-item)]
  (* (:a item) (:b item)))
