(ns permute
  (:use digits))

(defn seq-contains? [lst v]
  (< 0 (count (filter (partial = v) lst))))

(defn permute [lst]
  (loop [poss [[]]
         c (count lst)]
    (if (= 0 c)
      poss
      (let [nextStep (for [p poss
                           i (filter (comp
                                      not
                                      (partial seq-contains? p))
                                     lst)]
                       (cons i p))]
        (recur nextStep (dec c))))))

(defn num-permute [n]
  (map digToNum (permute (numToDig n))))

(def pandigitals
  (memoize (fn [n] (permute (range 1 (inc n))))))

(defn pandigital? [n]
  (let [dig (numToDig n)
        funcs (map #(partial = %) (range 1 (inc (count dig))))
        counts (for [f funcs]
          (count (filter f dig)))]
    (reduce
     #(and
       %1
       (= 1 %2))
     true
     counts)))
