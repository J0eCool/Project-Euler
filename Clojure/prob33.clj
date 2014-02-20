(ns prob33
  (:use digits))

(defn shared-digits [x y]
  (let [dx (numToDig x)
        dy (numToDig y)]
    (filter (partial seq-contains? dx) dy)))

(defn rem-shared [x y]
  (let [dx (numToDig x)
        dy (numToDig y)
        shared (shared-digits x y)
        lens (comp
              not
              (partial seq-contains? shared))
        f #(digToNum (filter lens %))]
    [(f dx)
     (f dy)]))

(defn silly-reduce [x y]
  (let [red (rem-shared x y)]
    (if (= 0 (second red))
      99999
      (/ (first red) (second red)))))

(silly-reduce 49 98)

(defn unDiv10 [n] (not= 0 (mod n 10)))

(def nums (filter #(:eq %) (for [d (filter unDiv10 (range 11 100))
      n (filter unDiv10 (range 11 d))]
  {:n n :d d :eq (and
                  (= (/ n d) (silly-reduce n d))
                  (not= d (second (rem-shared n d))))})))

nums

(let [n (reduce * (map :n nums))
      d (reduce * (map :d nums))]
  (/ n d))
