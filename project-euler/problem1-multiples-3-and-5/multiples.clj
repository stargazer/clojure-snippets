;If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
;Find the sum of all the multiples of 3 or 5 below 1000.

(defn is-multiple [n]
  ; Returns true if n is a multiple of 3 or 5, false otherwise
  (if (or (= (mod n 3) 0) (= (mod n 5) 0))
    true
    false))
  
(defn list-of-multiples [n]
  ; Returns a lazy seq of all natural numbers below ``n`` 
  ; that are multiples of 3 or 5
  (filter is-multiple (range 1 n)))

(defn sum-up-list [n]
  ; Returns the sum of all natural numbers below n, that are multiples of 3 or 5.
  (let [l (list-of-multiples n)]
    (loop [sum 0
           i 0]
      (if (= i (count l))
        sum
        (recur
          (+ sum (nth l i))
          (inc i)))
        )))

(println (sum-up-list 1000))






