(ns programacao-funcional.aula10)

(def pedido {
             :mochila  {
                        :quantidade 2
                        :preco      80
                        }
             :camiseta {
                        :quantidade 3
                        :preco      40
                        }
             :chaveiro {
                        :quantidade 1
                        }
             })

;(defn gratuito?
;  [[chave item]]
;  (<=
;    (get item :preco 0)
;    0))
;
;(println (filter gratuito? pedido))

(defn gratuito?
  [item]
  (<=
    (get item :preco 0)
    0))

(println (filter (fn [[chave item]] (gratuito? item)) pedido))
(println (filter #(gratuito? (second %)) pedido))

(defn pago?
  [item]
  (not (gratuito? item)))

(println (pago? {:preco 50}))
(println (pago? {:preco 0}))

(println ((comp not gratuito?) {:preco 50}))

(def pago? (comp not gratuito?))

(println (pago? {:preco 50}))
(println (pago? {:preco 0}))