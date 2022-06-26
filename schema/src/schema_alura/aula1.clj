(ns schema-alura.aula1
  (:use clojure.pprint)
  (:require [schema.core :as s]))

(defn adiciona-paciente [pacientes paciente]
  (if-let [id (:id paciente)]
    (assoc pacientes id paciente)
    (throw (ex-info "Paciente nao possui id" {:paciente paciente}))))

(defn adiciona-visita
  [visitas paciente novas-visitas]
  (if (contains? visitas paciente)
      (update visitas paciente concat novas-visitas)
      (assoc visitas paciente novas-visitas)
    ))

(defn imprime-relatorio-de-paciente [visitas paciente]
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
    (imprime-relatorio-de-paciente visitas daniela)))

(testa-uso-de-pacientes)

(pprint (s/validate Long 15))