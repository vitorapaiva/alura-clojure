(ns testes-clojure.logic-test
  (:require [clojure.test :refer :all]
            [clojure.pprint :refer :all]
            [testes-clojure.logic :refer :all]
            [testes-clojure.model :refer :all]
            [schema.core :as s]))
(s/set-fn-validation! true)
(let [
      hospital-espera-vazia {:espera (conj fila-vazia)}
      hospital-espera-cheia {:espera (conj fila-vazia 1, 35, 42, 64, 21)}
      hospital-espera-overbook {:espera (conj fila-vazia 1, 35, 42, 64, 21, 74)}
      hospital-espera-parcial {:espera (conj fila-vazia 1, 35, 42, 64)}
      hospital-espera-e-raiox {:espera (conj fila-vazia 1, 2), :raio-x (conj fila-vazia 4, 8)}
      hospital-espera-e-raiox-cheio {:espera (conj fila-vazia 1, 2), :raio-x (conj fila-vazia 3 2 7 5 6)}
      ]

  (deftest fila-existe?-test
    (testing "fila existe"
      (is (fila-existe? hospital-espera-vazia :espera)))
    (testing "fila nao existe"
      (is (not (fila-existe? {} :espera)))))

  (deftest cabe-na-fila?-test
    (testing "que cabe na fila vazia"
      (is (cabe-na-fila? hospital-espera-vazia :espera)))
    (testing "que cabe na fila quando ela esta parcialmente cheia"
      (is (cabe-na-fila? hospital-espera-parcial :espera)))
    (testing "que não cabe na fila quando ela esta cheia"
      (is (not (cabe-na-fila? hospital-espera-cheia :espera))))
    (testing "que não cabe na fila mesmo quando ela ja tem mais do que esperado"
      (is (not (cabe-na-fila? hospital-espera-overbook :espera))))
    (testing "que nao cabe quando departamento nao existe"
      (is (thrown? java.lang.AssertionError (cabe-na-fila? hospital-espera-cheia :raio-x)))))

  (deftest chega-em-test
    (testing "aceita pessoas enquanto cabem pessoas na fila"
      (is
        (=
          {:espera [1, 35, 42, 64, 5]}
          (chega-em {:espera [1, 35, 42, 64]}, :espera, 5)))
      (is
        (=
          {:espera [1, 5]}
          (chega-em {:espera [1]}, :espera, 5)))
      (is
        (=
          {:espera [5]}
          (chega-em hospital-espera-vazia, :espera, 5)))
      (is
        (thrown? java.lang.AssertionError
                 (chega-em {}, :espera, 5))))

    (testing "nao aceita quando nao cabe na fila"
      (is
        (thrown? clojure.lang.ExceptionInfo
                 (chega-em {:espera [1, 35, 42, 64, 21]}, :espera, 10)))))


  (deftest transfere-test
    (testing "aceita pessoas se cabe"
      (is
        (=
          {:espera [2], :raio-x [4 8 1]}
          (transfere hospital-espera-e-raiox :espera :raio-x))))

    (testing "nao aceita pessoas quando nao cabe"
      (is
        (thrown? clojure.lang.ExceptionInfo
          (transfere hospital-espera-e-raiox-cheio :espera :raio-x))))))