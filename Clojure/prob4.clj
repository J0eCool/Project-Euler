(ns prob4)

(defn digits [n]
  (if (< n 10) [n]
    (concat (digits (int (/ n 10))) [(mod n 10)])))

(defn palindrome? [list]
  (if (< (count list) 2) true
    (if (not= (first list) (last list)) false
      (let [sliced (drop 1 (drop-last 1 list))]
        (palindrome? sliced)))))

(defn palindrome-num? [n] (palindrome? (digits n)))

(reduce max (filter palindrome-num?
                    (for [i (range 100 1000)
                          j (range i 1000)]
                      (* i j))))