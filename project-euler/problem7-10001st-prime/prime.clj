(defn prime? [n]
  ; returns true if n is prime, false otherwise
  (loop [i 2]
    (if (> i (Math/sqrt n)) 
      true
      (if (= (mod n i) 0)
        false
        (recur (inc i))))))

(defn nth-prime [n]
  ; returns the nth prime number
  (loop [i 2
         primes []]

    
    (if (= (count primes) n)
      ; An (= (count primes)) return the last element of ``primes``
      (last primes)

      ; else, recur with parameters i, primes.
      ; where,
      ; i: (inc i)
      ; primes: if i is prime, append it
      (recur 
        (inc i)               
        (if (prime? i)
          (conj primes i)
          primes)))))


(println (nth-prime 6))
(println (nth-prime 10001))


