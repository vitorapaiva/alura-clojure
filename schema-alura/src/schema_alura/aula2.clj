(ns schema-alura.aula2
  (:use clojure.pprint)
  (:require [schema.core :as s]))
(s/set-fn-validation! true)

;(s/defrecord Paciente
;  [id :- Long nome :- s/Str])
;
;
;(pprint (->Paciente 15 "guilherme"))
;(pprint (->Paciente 15 15))

(def Paciente
  "schema de um paciente"
  {:id s/Num, :nome s/Str})

;(pprint (s/explain Paciente))
;(pprint (s/validate Paciente {:id 15 :nome "guilherme"}))

(s/defn novo-paciente :- Paciente
  [id :- s/Num, nome :- s/Str]
  {:id id, :nome nome})

(pprint (novo-paciente 15 "guilherme"))
;(pprint (novo-paciente 15 15))

(def EstritamentePositivo
  (s/pred pos?)
  )

(pprint (s/validate EstritamentePositivo 15))
;(pprint (s/validate EstritamentePositivo 0))
;(pprint (s/validate EstritamentePositivo -10))


(def Paciente
  "schema de um paciente"
  {:id (s/constrained s/Int pos?), :nome s/Str})

(pprint (s/validate Paciente {:id 15 :nome "guilherme"}))