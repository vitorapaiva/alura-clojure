(ns mutabilidade.core
  (:use [clojure.pprint])
  (:require [mutabilidade.model :as h.model]))

(let [hospital-do-gui (h.model/novo-hospital)]
  (pprint hospital-do-gui))

