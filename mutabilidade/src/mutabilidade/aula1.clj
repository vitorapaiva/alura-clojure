(ns mutabilidade.aula1
  (:use [clojure.pprint])
  (:require [mutabilidade.model :as h.model]
            [mutabilidade.logic :as h.logic]))

(defn simula-um-dia []
  (def hospital (h.model/novo-hospital))
  (def hospital (h.logic/chega-em hospital :espera "111"))
  (def hospital (h.logic/chega-em hospital :espera "222"))
  (def hospital (h.logic/chega-em hospital :espera "333"))
  (pprint hospital)
  (def hospital (h.logic/chega-em hospital :laboratorio1 "444"))
  (def hospital (h.logic/chega-em hospital :laboratorio3 "555"))
  (def hospital (h.logic/atende hospital :laboratorio1))
  (def hospital (h.logic/atende hospital :espera))
  (pprint hospital)

  (def hospital (h.logic/chega-em hospital :espera "666"))
  (def hospital (h.logic/chega-em hospital :espera "777"))
  (def hospital (h.logic/chega-em hospital :espera "888"))
  (pprint hospital)
  (def hospital (h.logic/chega-em hospital :espera "888")))

;(simula-um-dia)