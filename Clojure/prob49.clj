(ns prob49
  (:use primes)
  (:use digits)
  (:use permute))

(defn twice-in-list [lst n]
  (<= 2 (count (filter (partial = n) lst))))

(defn prime-perm [n]
  (let [perms (sort (filter isPrime (num-permute n)))
        nPerm (count perms)
        diffs (for [i (range 1 nPerm)
                    j (range 0 i)]
                (let [pi (nth perms i)
                      pj (nth perms j)]
                  (- pi pj)))
        repitar (distinct (filter
                           #(and (twice-in-list diffs %)
                                 (seq-contains? perms (+ n %)))
                           diffs))
        candide (for [r (range 1 10000)]
                  [(+ n r)
                   (+ n r r)])
        found (filter
               #(let [l (first %)
                      r (second %)]
                  (and
                   ;(isPrime l)
                   ;(isPrime r)
                   (seq-contains? perms l)
                   (seq-contains? perms r)
                  ))
               candide)]
    (flatten found)))

(filter
 #(< 0 (count (:p %)))
 (map
  (fn [x] {:n x :p (prime-perm x)})
  (filter isPrime (range 1000 10000))))