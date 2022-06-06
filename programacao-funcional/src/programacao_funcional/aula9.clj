(ns programacao-funcional.aula9)

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

(defn preco-dos-produtos
  [produto]
  (*
    (-> produto :quantidade)
    (-> produto :preco)))

; THREAD LAST
(defn total-do-pedido
  [pedido]
  (->> pedido
       vals
      (map preco-dos-produtos)
      (reduce +)))

(println (total-do-pedido pedido))