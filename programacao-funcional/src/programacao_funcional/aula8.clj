(ns programacao-funcional.aula8)

(def pedido {
             :mochila  {
                        :quantidade 2
                        :preco      80
                        }
             :camiseta {
                        :quantidade 3
                        :preco      40
                        }
             })

(println pedido)

(def pedido
  (assoc pedido :chaveiro {
                           :quantidade 1
                           :preco      10
                           }))

(println pedido)

(println (pedido :mochila))

(println (get pedido :mochila))

(println (:mochila pedido))
(println (:cadeira pedido))
(println (:cadeira pedido {}))                              ;com valor padrao vazio
(println (:quantidade (:mochila pedido)))

(println (update-in pedido [:mochila :quantidade] inc))

(println (-> pedido
             :mochila
             :quantidade))

