(ns record-protocol.aula2
  (:use clojure.pprint))

(defrecord PacienteParticular [id nome nascimento])
(defrecord PacientePlanoDeSaude [id nome nascimento plano])

(defprotocol Cobravel
  (deve-assinar-pre-autorizacao? [paciente procedimento valor]))

(extend-type PacienteParticular
  Cobravel
  (deve-assinar-pre-autorizacao? [paciente procedimento valor]
    (>= valor 50)))

(extend-type PacientePlanoDeSaude
  Cobravel
  (deve-assinar-pre-autorizacao? [paciente procedimento valor]
    (let [plano (:plano paciente)]
      (not (some #(= % procedimento) plano)))))

;outro caminho

(defrecord PacienteParticular [id nome nascimento]Cobravel
  (deve-assinar-pre-autorizacao? [paciente procedimento valor]
    (>= valor 50)))

(defrecord PacientePlanoDeSaude [id nome nascimento plano]Cobravel
  (deve-assinar-pre-autorizacao? [paciente procedimento valor]
    (let [plano (:plano paciente)]
      (not (some #(= % procedimento) plano)))))

(let [particular (->PacienteParticular 15 "guilherme" "11/11/1111")
      plano (->PacientePlanoDeSaude 15 "guilherme" "11/11/1111" [:raio-x :ultrassom])]
  (pprint (deve-assinar-pre-autorizacao? particular :raio-x 500))
  (pprint (deve-assinar-pre-autorizacao? particular :raio-x 40))
  (pprint (deve-assinar-pre-autorizacao? plano :raio-x 500))
  (pprint (deve-assinar-pre-autorizacao? plano :coleta-de-sangue 40))
  )

; uma variacao baseada na paletra do Sean Devlin sobre protocols na clojure Conj

(defprotocol Dateable
  (to-ms [this]))

(extend-type java.lang.Number
  Dateable
  (to-ms [this] this))

(extend-type java.util.Date
  Dateable
  (to-ms [this] (.getTime this)))


(pprint (to-ms (java.util.Date.)))