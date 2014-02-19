(def make
  (memoize
   (fn [n coins]
     (if (= 0 n)
       1
       (if (or (= 0 (count coins))
               (> (first coins) n))
         0
         (+
          (make (- n (first coins)) coins)
          (make n (rest coins))))))))

(make 200 [1 2 5 10 20 50 100 200])
