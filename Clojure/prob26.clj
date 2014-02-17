(def invDecDigits
  (comp
   #(nth % 1)
   (partial split-at 2)
   str
   #(/ 1 %)
   float))

(invDecDigits 3)
(invDecDigits 5)
(invDecDigits 7)

(defn repeatString [n]
  (let [leadSubstr (fn [sub lst]
                     (cond (= 0 (min (count sub) (count lst))) true
                           (not= (first sub) (first lst)) false
                           :else (recur (rest sub) (rest lst))))
        doesRepeat (fn [rep lst]
                     (if (= 0 (count lst)) true
                       (if (leadSubstr rep lst)
                         (recur rep (drop (count rep) lst))
                         false)))
        digits (invDecDigits n)]
    (loop [rep [(first digits)]
           lst digits]
      (if (= 0 (count lst))
        []
        (if (>= (count rep) (count lst))
          (let [new (rest lst)] (recur [(first new)] new))
          (if (doesRepeat rep lst)
            rep
            (recur (concat rep [(nth lst (count rep))]) lst)))))))

(repeatString 4)

(let [pairs (map (fn [n]
                   {:num n :len (count (repeatString n))})
                 (range 2 1000))
      ;pairs* (filter )
      m (reduce #(if (> (:len %1) (:len %2)) %1 %2)
                pairs)]
  m)

(invDecDigits 985)
