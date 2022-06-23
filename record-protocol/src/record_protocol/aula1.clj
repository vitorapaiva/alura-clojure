(ns record-protocol.aula1
  (:use clojure.pprint))

(defrecord Paciente [id nome nascimento])

(println (->Paciente 15 "guilherme" "18/09/1981"))
(println (Paciente. 15 "guilherme" "18/09/1981"))
(println (map->Paciente {:id 15 :nome "Guilherme" :nascimento "11/09/1111"}))

(defn adiciona-paciente
  [pacientes paciente]
  (if-let [id (:id paciente)]
    (assoc pacientes id paciente)
    (throw (ex-info "Paciente nao possui id" {:paciente paciente}))))

(defn testa []
  (let [pacientes {}
        guilherme {:id 15 :nome "Guilherme" :nascimento "11/09/1111"}
        daniela {:id 20 :nome "Daniela" :nascimento "18/09/1111"}
        paulo {:nome "Paulo" :nascimento "18/10/1111"}]
    (pprint (adiciona-paciente pacientes guilherme))
    (pprint (adiciona-paciente pacientes daniela))
    (pprint (adiciona-paciente pacientes paulo))))