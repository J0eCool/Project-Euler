(defrecord Date [month day year])

(defn isLeapYear [year]
  "Whether a given year is a leap year or not"
  (let [div4 (= 0 (mod year 4))
        div100 (= 0 (mod year 100))
        div400 (= 0 (mod year 400))]
    (and div4 (or (not div100) div400))))

(isLeapYear 1999)
(isLeapYear 1990)
(isLeapYear 1992)
(isLeapYear 2000)
(isLeapYear 1900)

(defn daysInYear [year]
  "Number of days in a given year"
  (if (isLeapYear year) 366 365))

(defn in-list? [list item]
  (some #(= % item) list))

(in-list? [4 6 9 11] 11)
(filter (partial in-list? [4 6 9 11]) (range 20))

(defn daysInMonth [month year]
  "Number of days in a given month (1=Jan, 2=Feb, etc)"
  (cond (= month 2) (if (isLeapYear year) 29 28)
        (in-list? [4 6 9 11] month) 30
        :else 31))

(map #(daysInMonth % 1990) (range 1 13))
(map #(daysInMonth % 1992) (range 1 13))

(defn daysSinceJan1 [date]
  (+ (.day date) -1
     (reduce + (map #(daysInMonth % (.year date)) (range 1 (.month date))))))

(daysSinceJan1 (Date. 1 1 1990))
(daysSinceJan1 (Date. 1 10 1990))
(daysSinceJan1 (Date. 2 1 1990))
(daysSinceJan1 (Date. 2 12 1990))
(daysSinceJan1 (Date. 3 12 1990))
(daysSinceJan1 (Date. 2 12 1992))
(daysSinceJan1 (Date. 3 12 1992))
(daysSinceJan1 (Date. 12 31 1992))

(defn daysSinceEpoch [date]
  "Number of days since Jan 1, 1900 at the given date"
  (+
   (daysSinceJan1 date)
   (reduce + (map daysInYear (range 1900 (.year date))))))

(daysSinceEpoch (Date. 1 1 1900))
(daysSinceEpoch (Date. 1 1 1901))
(daysSinceEpoch (Date. 1 1 1905))

(defn isSunday? [date]
  (= 6 (mod (daysSinceEpoch date) 7)))

(isSunday? (Date. 1 7 1900))

(+ 1 1)

(let [dateRange (for [y (range 1901 2001)
                      m (range 1 13)
                      d (range 1 (inc (daysInMonth m y)))]
                  (Date. m d y))
      sundays (filter isSunday? dateRange)
      firsts (filter #(= 1 (.day %)) sundays)]
  (count firsts))
