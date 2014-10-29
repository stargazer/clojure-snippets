( defn xconj
  "Builds up a very simple weighted tree, by adding the value ``v`` 
  to the given tree ``t``. 
  Every node is a map of {:val, :L, :R}.
  
  param t: tree representation, starting from root
  param v: value to add to tree
  
  Returns the tree.
  "
  [t v]
  (cond
        ; If tree t is empty
        (nil? t) {:val v, :L nil, :R nil}
        ; else if v < val(t), it ends up on t's left subtree
        (< v (:val t)) {:val (:val t), 
                        :L (xconj (:L t) v),
                        :R (:R t)}
        ; else, it ends up on t's right subtree
        :else          {:val (:val t),
                        :L (:L t),
                        :R (xconj (:R t) v)}))
                        


; testing
; ........

; tests
(def tests
  ['(xconj nil 5)                          ; Empty tree, add 5   
   '(xconj {:val 10, :L nil, :R nil} 1)    ; Tree with one node of val 10, add 1  
   '(xconj {:val 10, :L nil, :R nil} 20)]) ; Tree with one node of val 10, add 20 

; expected results
(def results
  [{:val 5, :L nil, :R nil}
   {:val 10, :L {:val 1, :L nil, :R nil}, :R nil}
   {:val 10, :L nil, :R {:val 20, :L nil, :R nil}}])

; test runner
(doseq [i (range (count tests))
        :let [t (nth tests i) 
              r (nth results i)]]

  (println "Test" (inc i))
  (println t)
  (println r)
  (cond
    (= (eval t) r) (println "Pass")
    :else   (println "Fail"))
  
  (println)
)


