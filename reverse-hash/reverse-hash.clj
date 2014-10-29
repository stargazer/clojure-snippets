"
Solution

t1 = t0 * 41 + index_of_first_letter
t2 = t1 * 41 + index_of_second_letter
...
t8 = t7 * 41 + index_of_8th_letter

where ``index_of_nth_letter``` represents the index of the letter n of
``le_string`` within the ``letters`` array. It's a number between 1 and 17.
 
So,
index_of_8th_letter = t8 % 41 => 8th_letter = letters[index_of_8th_letter]
t7 = t8 / 41
...
"

(defn get-index [t]
  (mod t 41))

(defn get-previous-t [t]
  (/ t 41))

(defn get-char [i]
  ; Returns the character with index ``i``
  (let [letters [\a \c \d \e \g \h \i \l \m \n \o \p \r \s \t \u \w \z]]
    (nth letters i)))

(defn find-string [hash]
  ; Returns the string that generated hash ``hash``
  (loop [word '()
         t hash]
    (if (= (count word) 8)
      ; if length of ``word`` is 8, return ``word``
      word
      ; else: 
      ;       Find the nth character (where n is the # of iteration)
      ;       Find the ``t(n-1)``
      ;       Call the next iteration with:
      ;         word = word + prepend the new character
      ;         t = t(n-1)
      (recur (conj word (get-char (get-index t))) (/ t 41)))))

(println (find-string 56721274917700))




