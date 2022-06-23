(ns record-protocol.logic
  (:require [record-protocol.model
             :as
             rp.model]))

(defn agora []
  (rp.model/to-ms (java.util.Date.)))