(let [input (map read-string (clojure.string/split (slurp *in*) #"\n"))
      character-counts (map #(set (map count (partition-by identity (sort %)))) input)
      part1 (*
              (count (filter #(% 3) character-counts))
              (count (filter #(% 2) character-counts)))
      box-id-pairs (for [i input j input] (list i j))
      part2 (reduce
              (fn [acc val]
                (let [pairs (group-by
                    #(= (first %) (last %))
                    (partition 2 (interleave (first val) (last val))))]
                  (if
                    (= 1 (count (pairs false)))
                    (reduced (apply str (map (partial first) (pairs true))))
                    (conj acc val))))
                  box-id-pairs)]
  (do
    (println "Part 1: " part1)
    (println "Part 2: " part2)))
