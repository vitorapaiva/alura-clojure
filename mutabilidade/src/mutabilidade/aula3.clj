(ns mutabilidade.aula3
  (:use [clojure.pprint])
  (:require [mutabilidade.logic :as h.logic]
            [mutabilidade.model :as h.model]))

;(defn testa-atomao []
;  (let [hospital-silveira (atom {:espera h.model/fila-vazia})]
;    (swap! hospital-silveira assoc :laboratorio1 h.model/fila-vazia)
;    (swap! hospital-silveira assoc :laboratorio2 h.model/fila-vazia)
;    (swap! hospital-silveira update :laboratorio1 conj "111")
;    hospital-silveira))
;(pprint (testa-atomao))
(defn chega-sem-malvado!
  [hospital pessoa]
  (swap! hospital h.logic/chega-em-pausado :espera pessoa))

(defn simula-um-dia-em-paralelo
  []
  (let [hospital (atom (h.model/novo-hospital))]
    (.start (Thread. (fn [] (chega-sem-malvado! hospital "111"))))
    (.start (Thread. (fn [] (chega-sem-malvado! hospital "222"))))
    (.start (Thread. (fn [] (chega-sem-malvado! hospital "333"))))
    (.start (Thread. (fn [] (chega-sem-malvado! hospital "444"))))
    (.start (Thread. (fn [] (chega-sem-malvado! hospital "555"))))
    (.start (Thread. (fn [] (chega-sem-malvado! hospital "666"))))
    (.start (Thread. (fn [] (Thread/sleep 8000)
                       (pprint hospital))))))

(simula-um-dia-em-paralelo)