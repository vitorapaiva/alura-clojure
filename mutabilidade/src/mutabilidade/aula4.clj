(ns mutabilidade.aula4
  (:use [clojure.pprint])
  (:require [mutabilidade.logic :as h.logic]
            [mutabilidade.model :as h.model]))

(defn chega-sem-malvado!
  [hospital pessoa]
  (swap! hospital h.logic/chega-em-pausado :espera pessoa))

;(defn simula-um-dia-em-paralelo
; "Variacao usando mapv pra forcar execucao
;  []
;  (let [hospital (atom (h.model/novo-hospital))
;        pessoas ["111" "222" "333" "444" "555" "666"]]
;    (mapv #(.start (Thread. (fn [] (chega-sem-malvado! hospital %)))) pessoas)
;    (.start (Thread. (fn [] (Thread/sleep 8000)
;                       (pprint hospital))))))

;(defn simula-um-dia-em-paralelo
;  "Variacao com funcao criada no let"
;  []
;  (let [hospital (atom (h.model/novo-hospital))
;        pessoas ["111" "222" "333" "444" "555" "666"]
;        starta-thread-de-chegada #(.start (Thread. (fn [] (chega-sem-malvado! hospital %))))]
;    (mapv starta-thread-de-chegada pessoas)
;    (.start (Thread. (fn [] (Thread/sleep 8000)
;                       (pprint hospital))))))

;(defn starta-thread-de-chegada
;  [hospital pessoa]
;  (.start (Thread. (fn [] (chega-sem-malvado! hospital pessoa)))))
;
;(defn preparadinha
;  [hospital]
;  (fn
;    [pessoa]
;    (starta-thread-de-chegada hospital pessoa)))
;
;(defn simula-um-dia-em-paralelo
;  []
;  (let [hospital (atom (h.model/novo-hospital))
;        pessoas ["111" "222" "333" "444" "555" "666"]]
;    (mapv (preparadinha hospital) pessoas)
;    (.start (Thread. (fn [] (Thread/sleep 8000)
;                       (pprint hospital))))))

;(defn starta-thread-de-chegada
;  ([hospital]
;   (fn
;     [pessoa]
;     (starta-thread-de-chegada hospital pessoa)))
;
;  ([hospital pessoa]
;   (.start (Thread. (fn [] (chega-sem-malvado! hospital pessoa))))))
;
;(defn simula-um-dia-em-paralelo
;  []
;  (let [hospital (atom (h.model/novo-hospital))
;        pessoas ["111" "222" "333" "444" "555" "666"]
;        starta (starta-thread-de-chegada hospital)]
;    (mapv starta pessoas)
;    (.start (Thread. (fn [] (Thread/sleep 8000)
;                       (pprint hospital))))))

;(defn starta-thread-de-chegada
;  [hospital pessoa]
;  (.start (Thread. (fn [] (chega-sem-malvado! hospital pessoa)))))
;
;(defn simula-um-dia-em-paralelo
;  []
;  (let [hospital (atom (h.model/novo-hospital))
;        pessoas ["111" "222" "333" "444" "555" "666"]
;        starta (partial starta-thread-de-chegada hospital)]
;    (mapv starta pessoas)
;    (.start (Thread. (fn [] (Thread/sleep 8000)
;                       (pprint hospital))))))

(defn starta-thread-de-chegada
  [hospital pessoa]
  (.start (Thread. (fn [] (chega-sem-malvado! hospital pessoa)))))

;(defn simula-um-dia-em-paralelo
;  []
;  (let [hospital (atom (h.model/novo-hospital))
;        pessoas ["111" "222" "333" "444" "555" "666"]]
;    (doseq [pessoa pessoas]
;      (starta-thread-de-chegada hospital pessoa))
;    (.start (Thread. (fn [] (Thread/sleep 8000)
;                       (pprint hospital))))))

(defn simula-um-dia-em-paralelo
  []
  (let [hospital (atom (h.model/novo-hospital))]
    (dotimes [pessoa 6]
      (starta-thread-de-chegada hospital pessoa))
    (.start (Thread. (fn [] (Thread/sleep 8000)
                       (pprint hospital))))))


(simula-um-dia-em-paralelo)
