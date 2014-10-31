(defn divisible? [n, i]
  ; true if n is divisible by i, false otherwise
  (if (= (mod n i) 0)
    true
    false))

(defn divisible-by-all? [n, s]
  ; true if n is divisible by all numbers in s, false otherwise
  (if (every? (partial divisible? n) s)
    true
    false))

(defn filter-list [s]
  ; Scans list ``s``and returns another list with the items in s, 
  ; that don't have their double in s.
  (let [s (set s)]
    (for [i s
          :when (not (contains? s (* i 2)))]
      i)))

(defn smallest-divisible-by-all [s]
  " Returns the smallest number that's divisible by all numbers in s.
  I've made the following observations, which reduce complexity:

  - If a number is divisible by 2i then it's also divisible by i. Since 
  the list s starts from 1 till n, we only use the part from (n/2 ~ n).

  - Since the number we are looking for, has to be a multiple of all 
  the numbers in the list ``s``, we take the largest number of ``s`` as
  our starting point, and increment by it in every iteration."

  (let [s (drop (Math/floor (/ (count s) 2.0)) s) ; Take it from half till end
        largest (last s)]                         ; Equal to the largest number in s                                  
    (loop [n largest]
      (if (divisible-by-all? n s)
        n
        (recur (+ n largest))))))

(time (println (smallest-divisible-by-all (range 1 21))))
