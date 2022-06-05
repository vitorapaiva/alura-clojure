(ns programacao-funcional.aula4)

(def precos [30 700 1000])

(println (precos 0))
(println (get precos 0))
(println "valor padrao nill" (get precos 17))
(println "valor padrao 0" (get precos 17 0))
(println "valor padrao 0, mas existe" (get precos 2 0))
(println (conj precos 5))
(println precos)
(println (update precos 0 inc))
(println (update precos 0 dec))

(defn soma-3
  [valor]
  (+ valor 3))

(println (update precos 0 soma-3))
