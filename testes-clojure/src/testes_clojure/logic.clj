(ns testes-clojure.logic
  (:require
    [schema.core :as s]
    [testes-clojure.model :refer :all]))

(defn fila-existe? [hospital, departamento]
  (contains? hospital departamento))

(defn cabe-na-fila? [hospital, departamento]
  {
   :pre [(fila-existe? hospital departamento)]
   }
  (-> hospital
      departamento
      count
      (< 5)))

(defn chega-em
  [hospital departamento pessoa]
  (if (cabe-na-fila? hospital departamento)
    (update hospital departamento conj pessoa)
    (throw (ex-info "Fila cheia" hospital))))

(s/defn atende :- Hospital
  [hospital :- Hospital departamento :- s/Keyword]
  (update hospital departamento pop))

(s/defn proxima
  [hospital :- Hospital departamento :- s/Keyword]
  (-> hospital
      departamento
      peek))

(s/defn transfere :- Hospital
  [hospital :- Hospital de :- s/Keyword para :- s/Keyword]
  {
   :pre [(fila-existe? hospital de), (fila-existe? hospital para)]
   }
  (let [pessoa (proxima hospital de)]
    (-> hospital
        (atende de)
        (chega-em para pessoa))))