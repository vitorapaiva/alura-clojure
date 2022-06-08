(ns mutabilidade.aula2
  (:use [clojure.pprint])
  (:require [mutabilidade.model :as h.model]
            [mutabilidade.logic :as h.logic]))
(def hospital (h.model/novo-hospital))
(defn chega-em-malvado
  [pessoa]
  (def hospital (h.logic/chega-em-pausado hospital :espera pessoa)))

(defn simula-um-dia-em-paralelo
  []
  (def hospital (h.model/novo-hospital))
  (.start (Thread. (fn [] (chega-em-malvado 111))))
  (.start (Thread. (fn [] (chega-em-malvado 222))))
  (.start (Thread. (fn [] (chega-em-malvado 333))))
  (.start (Thread. (fn [] (chega-em-malvado 444))))
  (.start (Thread. (fn [] (chega-em-malvado 555))))
  (.start (Thread. (fn [] (chega-em-malvado 666))))
  (.start (Thread. (fn [] (Thread/sleep 4000)
                     (pprint hospital))))
  )

(simula-um-dia-em-paralelo)

