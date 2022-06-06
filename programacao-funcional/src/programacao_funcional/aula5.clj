(ns programacao-funcional.aula5)

(def precos [30 700 1000])

(defn aplica-desconto?
  [valor-bruto]
  (> valor-bruto 100))

(defn valor-descontado
  [valor-bruto]
  (if (aplica-desconto? valor-bruto)
    (let [taxa-de-desconto (/ 10 100)
          desconto (* valor-bruto taxa-de-desconto)]
      (- valor-bruto desconto))
    valor-bruto))

(println "map" (map valor-descontado precos))

(println (range 10))
(println (filter even? (range 10)))


(println "filter" (filter aplica-desconto? precos))

(println "maps apos filter" (map valor-descontado (filter aplica-desconto? precos)))

