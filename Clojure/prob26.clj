(def invDecDigits
  (comp
   #(nth % 1)
   (partial split-at 2)
   str
   #(/ 1 %)
   float))

(invDecDigits 3)

(map invDecDigits
     (range 2 10))
