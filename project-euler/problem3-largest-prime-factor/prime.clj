(defn divisible? [n, i]
  ; true if i is a factor of n. false otherwise
  (if (= (mod n i) 0)
    true
    false))

(defn prime? [n]
  ; true if n is prime. false otherwise
  (let [sqrt (Math/sqrt n)
        divisors (for [i (range 2 sqrt) :when (= (mod n i) 0)] i)]
    (if (empty? divisors)
      true
      false)))

(defn factors [n]
  ;returns a lazy sequence with all the factors of n, from 2 until (sqrt n)
  ; Why? Any number's prime factor cannot be greater than its square root.
  (filter
    (partial divisible? n)  ; partial: https://clojuredocs.org/clojure.core/partial
    (range 2 (Math/sqrt n))))

(defn prime-factors [n]
  ; returns a lazy sequence with the prime factors of n
  (filter prime? (factors n)))

(defn largest-prime [n]
  (apply max (prime-factors n))) ; Using ``apply max`` allows us to find the maximum value within the given list
                                 ; http://clojuredocs.org/clojure.core/apply     

(println (largest-prime 13195))
(println (largest-prime 600851475143))
