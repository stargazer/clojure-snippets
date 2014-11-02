(defn ispalindrome? [n]
  ; Returns true if n is a palindrome, false otherwise
  (let [v (vec (str n))]  ; Transform v to a vector of characters
    (loop [v v]
      (if (<= (count v) 1)
        true
        (if (= (first v) (last v))
          (recur (drop-last (drop 1 v)))
          false)))))

(defn palindromes [n]
  ; Returns all palindrome numbers, which are product of 2 n-digit numbers
  (for [i (range (int (Math/pow 10 (dec n))) (int (Math/pow 10 n))) ; 10^(n-1) ~ 10^n
        j (range (int (Math/pow 10 (dec n))) (int (Math/pow 10 n)))
        :let [product (* i j)]
        :when (ispalindrome? product) ]
    product))

(println (apply max (palindromes 2)))
(println (apply max (palindromes 3)))

