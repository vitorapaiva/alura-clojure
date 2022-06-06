(ns colecoes-dia-a-dia.aula2)

(defn meu-mapa
  [funcao sequencia]
  (let [primeiro (first sequencia)]
    (if (not (nil? primeiro))
      (do
        (funcao primeiro)
        (recur funcao (rest sequencia))))))


(meu-mapa println (range 10000))