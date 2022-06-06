(ns programacao-funcional.aula6)

(def precos [30 700 1000])

(defn minha-soma
  [valor-1 valor-2]
  (println "somando" valor-1 valor-2)
  (+ valor-1 valor-2))

(println (reduce minha-soma precos))

(println (reduce minha-soma 0 precos))
