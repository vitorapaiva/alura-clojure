(ns colecoes-dia-a-dia.aula6
  (:require [colecoes-dia-a-dia.db :as l.db]
            [colecoes-dia-a-dia.logica :as l.logic]))

(println (l.db/todos-os-pedidos))

(let [pedidos (l.db/todos-os-pedidos)
      resumo (l.logic/resumo-por-usuario pedidos)]
  (println "resumo" resumo)
  (println "ordenado" (sort-by :preco-total resumo))
  (println "ordenado reverso" (reverse (sort-by :preco-total resumo)))
  (println "ordenado por id" (sort-by :usuario-id resumo))
  (println (get-in pedidos [0 :itens :mochila :quantidade])))

(defn resumo-por-usuario-ordenado [pedidos]
  (->> pedidos
       (l.logic/resumo-por-usuario)
       (sort-by :preco-total)
       reverse))

(let [pedidos (l.db/todos-os-pedidos)
      resumo (resumo-por-usuario-ordenado pedidos)]
  (println "resumo" resumo)
  (println "primeiro" (first resumo))
  (println "segundo" (second resumo))
  (println "resto" (rest resumo))
  (println "total" (count resumo))
  (println "class" (class resumo))
  (println "nth 1" (nth resumo 1))
  (println "take" (take 2 resumo )))

(let [pedidos (l.db/todos-os-pedidos)
      resumo (resumo-por-usuario-ordenado pedidos)]
  (println "quem gastou mais que 500" (filter #(> (:preco-total %) 500) resumo))
  (println "alguem gastou mais que 500" (some #(> (:preco-total %) 500) resumo)))

