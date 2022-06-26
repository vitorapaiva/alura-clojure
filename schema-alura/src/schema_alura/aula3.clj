(ns schema-alura.aula3
  (:use clojure.pprint)
  (:require [schema.core :as s]))
(s/set-fn-validation! true)

(defn maior-ou-igual-a-zero? [num]
  (>= num 0))

(def ValorFinanceiro (s/constrained s/Num maior-ou-igual-a-zero?))

(def PostInt (s/pred pos-int?))

(def Paciente
  "schema de um paciente"
  {:id PostInt, :nome s/Str})

(def Pedido
  {:paciente     Paciente,
   :valor        ValorFinanceiro
   :procedimento s/Keyword})

(def Plano [s/Keyword])

(s/defn novo-paciente :- Paciente
  [id :- PostInt
   nome :- s/Str]
  {:id id, :nome nome})

(pprint (novo-paciente 15, "Guilherme"))
; (pprint (novo-paciente -15, "Guilherme"))

(s/defn novo-pedido :- Pedido
  [paciente :- Paciente, valor :- ValorFinanceiro, procedimento :- s/Keyword]
  {
   :paciente paciente, :valor valor, :procedimento procedimento
   })

(pprint (novo-pedido (novo-paciente 15, "Guilherme"), 15.53, :raio-x))

