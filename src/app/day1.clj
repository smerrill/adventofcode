(let [input (map read-string (clojure.string/split (slurp *in*) #"\n"))
      frequencies (reductions + (cycle input))
      part1 (reduce + input)
      part2 (reduce
              (fn [acc val]
                (if
                  (acc val)
                  (reduced val)
                  (conj acc val)))
                #{0} frequencies)]
       (do
        (println "Part 1: " part1)
        (println "Part 2: " part2)))
