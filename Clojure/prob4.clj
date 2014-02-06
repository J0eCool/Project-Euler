 (defn digits [n]
   (if (< n 10) [n]
     (concat (digits (int (/ n 10))) [(mod n 10)])))

 (defn palindrome? [list]
   (if (< (count list) 2) true
     (if (not= (first list) (last list)) false
       (let [sliced (drop 1 (drop-last 1 list))]
         (palindrome? sliced)))))

 (defn palindrome-num? [n] (palindrome? (digits n)))

 (not= 1 2)

 (concat [1] [2 3 4])

 (palindrome-num? 42324)

 (filter palindrome-num? (range 1205))

 (let [L [8 6 7 3 45 9]]
   (last L))

 (reduce max (filter palindrome-num?
                     (for [i (range 100 1000)
                           j (range i 1000)]
                       (* i j))))