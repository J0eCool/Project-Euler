(defmacro memo-defn [name & body]
  `(def ~name (memoize (fn ~body))))

(memo-defn
 fib [n]
 (if (< n 2) 1N
   (+ (fib (dec n))
      (fib (- n 2)))))

(with-out-str (time (fib 939)))

(map fib (range 10))

(memo-defn
 collatz-length [n]
 (if (= n 1)
   1
   (let [next (if (even? n)
                (/ n 2)
                (inc (* 3 n)))]
     (+ 1 (collatz-length next)))))

(collatz-length 1)
(collatz-length 2)
(collatz-length 13)

(let [pairs (map
            (fn [n] {:num n :len (collatz-length n)})
            (range 1 1000000))
      maxLen (reduce
              (fn [a b] (if (> (:len a) (:len b)) a b))
              pairs)]
  (:num maxLen))
