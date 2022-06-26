(ns schema-alura.aula4
  (:use clojure.pprint)
  (:require [schema.core :as s]))
(s/set-fn-validation! true)

(def PosInt (s/pred pos-int?))
(def Plano [s/Keyword])
(def Paciente
  "schema de um paciente"
  {:id PosInt,
   :nome s/Str,
   :plano Plano
   (s/optional-key :nascimento) s/Str})

(pprint (s/validate Paciente {:id 15, :nome "guilherme", :plano [:raio-x, :ultrassom]}))
(pprint (s/validate Paciente {:id 15, :nome "guilherme", :plano nil}))
(pprint (s/validate Paciente {:id 15, :nome "guilherme", :plano nil, :nascimento "18/18/2018"}))

(def Visitas {PosInt [s/Str]})