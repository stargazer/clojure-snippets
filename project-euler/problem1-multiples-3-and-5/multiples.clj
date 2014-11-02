(defn is-multiple [n]
  ; Returns true if n is a multiple of 3 or 5, false otherwise
  (if (or (= (mod n 3) 0) (= (mod n 5) 0))
    true
    false))
  
(defn list-of-multiples [n]
  ; Returns a lazy seq of all natural numbers below ``n`` 
  ; that are multiples of 3 or 5
  (filter is-multiple (range 1 n)))

(defn sum-multiples [n]
  ; Returns the sum of all natural numbers below n, that are multiples of 3 or 5.
  (reduce + (list-of-multiples n)))

(println (sum-multiples 10))
(println (sum-multiples 1000))






