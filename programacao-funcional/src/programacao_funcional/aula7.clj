(ns programacao-funcional.aula7)

(def estoque {:mochila  10
              :camiseta 5})

(println estoque)

(println "temos" (count estoque))

(println "chaves" (keys estoque))
(println "valores" (vals estoque))

(println (assoc estoque :cadeira 3))
(println (assoc estoque :mochila 1))
(println (update estoque :mochila inc))

(defn tira-um
  [valor]
  (println "tirando um de" valor)
           (- valor 1))

(println (update estoque :mochila tira-um))
(println (update estoque :mochila #(- % 3)))
(println (dissoc estoque :mochila))
