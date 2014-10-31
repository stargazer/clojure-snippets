(defn square [n]
  ; returns the square of n
  (* n n))

(defn sum-squares [s]
  ; returns the sum of squares of the elements of sequence s
  (reduce + (for [i s] (square i))))

(defn square-of-sum [s]
  ; returns the square of the sum of the elements of sequence s
  (square (reduce + s)))

(defn difference [s]
  ; returns the difference between the square of the sums the elements of ``s``,
  ; minus the sum of the squares of its items.
  (- (square-of-sum s) (sum-squares s)))

(println (difference (range 11)))
(println (difference (range 21)))
