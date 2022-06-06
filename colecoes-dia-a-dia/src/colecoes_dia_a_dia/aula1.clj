(ns colecoes-dia-a-dia.aula1)


;(map println vetor-exemplo)
;(println (rest vetor-exemplo))
;(println (rest []))
;(println (next vetor-exemplo))
;(println (next []))
;(println (seq []))
;(println (seq [1 2 3 5]))

(def vetor-exemplo ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"])
(def vetor-exemplo2 ["daniela" false "guilherme" "carlos" "paulo" "lucia" "ana"])
(defn meu-mapa
  [funcao sequencia]
  (let [primeiro (first sequencia)]
    (if (not (nil? primeiro))
      (do
        (funcao primeiro)
        (meu-mapa funcao (rest sequencia))))))

(println "\n\nexemplo 1")
(meu-mapa println vetor-exemplo)
(println "\n\nexemplo 2")
(meu-mapa println vetor-exemplo2)
(println "\n\nexemplo 3")
(meu-mapa println [])
(println "\n\nexemplo 4")
(meu-mapa println nil)
(println "\n\nexemplo 5")
(meu-mapa println (range 1000000))