(ns primes)

(defn isPrime [n]
  (cond (= n 2) true
        (< n 2) false
        :else (let [hi (int (Math/ceil (Math/sqrt n)))
                    divs (drop-while #(not= 0 (mod n %)) (range 2 (inc hi)))]
                (= 0 (count divs)))))

(map isPrime [2 3 5 7 11 13 17])
(map isPrime [4 6 8 10 9 12 15 18 20])
(filter isPrime (range 1000))
