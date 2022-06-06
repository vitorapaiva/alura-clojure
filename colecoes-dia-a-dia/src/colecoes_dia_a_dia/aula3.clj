(ns colecoes-dia-a-dia.aula3)

(def vetor-exemplo ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"])

;(defn conta
;  [total-ate-agora elementos]
;  (if (seq elementos)
;    (recur (inc total-ate-agora) (next elementos))
;    total-ate-agora))
;
;(println (conta 0 vetor-exemplo))
;(println (conta 0 []))

(defn conta
  ([elementos]
   (conta 0 elementos))

  ([total-ate-agora elementos]
   (if (seq elementos)
     (recur (inc total-ate-agora) (next elementos))
     total-ate-agora)))

(println (conta 0 vetor-exemplo))
(println (conta 0 []))
(println (conta vetor-exemplo))
(println (conta []))