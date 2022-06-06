(ns colecoes-dia-a-dia.aula4)

(def vetor-exemplo ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"])

(defn conta
  [elementos]
  (loop [total-ate-agora 0
         elementos-restantes elementos]
    (if (seq elementos-restantes)
      (recur
        (inc total-ate-agora)
        (next elementos-restantes))
      total-ate-agora)))

(println (conta vetor-exemplo))
(println (conta []))
