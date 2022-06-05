(ns programacao-funcional.aula3)
(defn mais-caro-que-cem?
  [valor-bruto]
  (> valor-bruto 100))



(defn valor-descontado
  "Retorna o valor com desconto de 10% se o valor bruto for estritamente maior que 100."
  [aplica? valor-bruto]
  (if (mais-caro-que-cem? valor-bruto)
    (let [taxa-de-desconto (/ 10 100)
          desconto (* valor-bruto taxa-de-desconto)]
      (- valor-bruto desconto))
    valor-bruto))

(println (valor-descontado mais-caro-que-cem? 1000))

(println (valor-descontado mais-caro-que-cem? 100))

(println (mais-caro-que-cem? 1000))
(println (mais-caro-que-cem? 100))