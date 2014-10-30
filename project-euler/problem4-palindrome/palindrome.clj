(defn ispalindrome? [n]
  ; Returns true if n is a palindrome, false otherwise
  (let [v (vec (str n))]  ; Transform v to a vector of characters
    (loop [v v]
      (if (<= (count v) 1)
        true
        (if (= (first v) (last v))
          (recur
            (subvec v 1 (dec (count v))))
          false)))))


(def palindromes
  ; binds ``palindromes`` to a lazy sequence of palindrome numbers, 
  ; which are product of 3-digit numbers 
  (for [i (range 100 1000)
        j (range 100 1000)
        :let [product (* i j)]
        :when (ispalindrome? product) ]
    product))


(println (apply max palindromes))

