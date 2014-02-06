(ns prob2)

(def fib (memoize (fn [n]
  (if (< n 1) 1
    (+ (fib (- n 1)) (fib (- n 2)))))))

(defn gen-fib [] (map fib (range)))

(let [fibs (take-while (partial > 4000000) (gen-fib))]
  (reduce + (filter even? fibs)))
