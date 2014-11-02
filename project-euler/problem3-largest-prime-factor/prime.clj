(defn divisible? [n, i]
  ; true if i is a factor of n. false otherwise
  (if (= (mod n i) 0)
    true
    false))

(defn prime? [n]
  (loop [i 2]
    (if (>= i (Math/ceil (Math/sqrt n)))
      true
      (if (= (mod n i) 0)
        false
        (recur (inc i))))))

(defn prime-factors [n]
  ; returns a lazy sequence of n's prime-factors
  (for [i (range 2 (Math/ceil (Math/sqrt n))) 
        :when (and
                (= (mod n i) 0) 
                (prime? i))]  
    i))

(defn max-prime [n]
  ; returns n's largest prime factor
  (apply max (prime-factors n)))

(println (max-prime 13195))
(println (max-prime 600851475143))



    
