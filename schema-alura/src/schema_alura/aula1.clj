(ns schema_alura.aula1
  (:use clojure.pprint)
  (:require [schema.core :as s]))
(s/set-fn-validation! true)

(s/defn adiciona-paciente [pacientes paciente]
  (if-let [id (:id paciente)]
    (assoc pacientes id paciente)
    (throw (ex-info "Paciente nao possui id" {:paciente paciente}))))

(s/defn adiciona-visita
  [visitas paciente novas-visitas]
  (if (contains? visitas paciente)
      (update visitas paciente concat novas-visitas)
      (assoc visitas paciente novas-visitas)
    ))

(s/defn imprime-relatorio-de-paciente [visitas paciente :- Long]
  (println "Visitas do paciente" paciente "são" (get visitas paciente))
  )

(defn testa-uso-de-pacientes []
  (let [guilherme {:id 15 :nome "Guilherme"}
        daniela {:id 20 :nome "Daniela"}
        paulo {:id 25 :nome "Paulo"}
        pacientes (reduce adiciona-paciente {} [guilherme daniela paulo])
        visitas {}
        visitas (adiciona-visita visitas 15 ["01/01/0001"])
        visitas (adiciona-visita visitas 20 ["01/01/0001", "01/01/0001"])
        visitas (adiciona-visita visitas 15 ["01/01/0001"])]
    (pprint pacientes)
    (pprint visitas)
    ;(imprime-relatorio-de-paciente visitas daniela)
    ))

(testa-uso-de-pacientes)

;(s/defn teste-simples [x :- Long]
;  (println x))
;
;(teste-simples 15)
;(teste-simples "guilherme")

(s/defn novo-paciente
  [id :- Long nome :- s/Str]
  {:id id :nome nome})

(pprint (novo-paciente 15 "Teste"))
;(pprint (novo-paciente "Teste" 15))