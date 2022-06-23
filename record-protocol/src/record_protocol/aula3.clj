(ns record-protocol.aula3
  (:use clojure.pprint)
  (:require [record-protocol.logic
             :as
             rp.logic]))

(defn carrega-paciente [id]
  (println "Carregando" id)
  (Thread/sleep 1000)
  {:id id :carregado-em (rp.logic/agora)}
  )

(defn carrega-se-nao-existe
  [pacientes id carregadora]
  (if (contains? pacientes id)
    pacientes
    (let [paciente (carregadora id)]
      (assoc pacientes id paciente))))

(println (carrega-se-nao-existe {} 15 carrega-paciente))
(println (carrega-se-nao-existe {15 {:id 15}} 15 carrega-paciente))

(defprotocol Carregavel
  (carrega! [this id]))

(defrecord Cache
  [cache carregadora]
  Carregavel
  (carrega! [this id]
    (swap! cache carrega-se-nao-existe id carregadora)
    (get @cache id)))

(def pacientes (->Cache (atom {}) carrega-paciente))

(carrega! pacientes 15)
(carrega! pacientes 30)
(carrega! pacientes 15)
(pprint pacientes)