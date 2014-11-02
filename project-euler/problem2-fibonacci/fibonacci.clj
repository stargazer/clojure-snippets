(defn fibonacci [n]
  ; Return a vector of the fibonacci series, with terms not exceeding ``n``
  (loop [fib [1 2]]
    (let [l (last fib)            ; last
          pl (last (butlast fib)) ; prelast
          next-term (+ l pl)]     ; next term of fibonacci series

      (if (>= next-term n)
        fib
        (recur (conj fib next-term))))))

(defn get-even [v]
  ; Return the even numbers from a given vector ``v``
  (filter even? v))

(defn sum-even-fibonacci [n]
  ; Returns the sum of all even numbers in the fibonacci series, whose value doesnt' exveed 4 million
  (reduce + (get-even (fibonacci n))))

(println (sum-even-fibonacci 4000000))
    


    





