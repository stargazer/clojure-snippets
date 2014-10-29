(defn fibonacci [n]
  ; Return a vector of the fibonacci series, from 1 to n
  (loop [fib [1 2]]
    (let [lst (last fib) prelast (last (butlast fib))]
      (if (>= (+ lst prelast) n)
        fib
        (recur (conj fib (+ lst prelast)))))))

(defn get-even [v]
  ; Return the even numbers from a given vector ``v``
  (filter even? v))

(defn sum-even-fibonacci [n]
  ; Returns the sum of all even numbers in the fibonacci series, whose value doesnt' exveed 4 million
  (reduce + (get-even (fibonacci n))))

(println (sum-even-fibonacci 4000000))
    


    





