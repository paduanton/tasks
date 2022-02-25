;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname lista3-AntonioDePaduaSantosJunior-D) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
(require 2htdp/image)

;; ==============================================================
;;                       QUESTÃO 1
;; ==============================================================
;; -----------------
;; TIPO CARTA:
;; -----------------
(define-struct carta (naipe valor))
;; Um elemento do conjunto Carta é
;; uma estrutura (make-carta naipe valor) onde
;; naipe : String, é o naipe da carta, que pode ser "paus", "espadas", "copas", "ouros" ou "nenhum"
;; valor : Número, é o valor da carta entre 1 e 10


;; -----------------
;; TIPO MÃO:
;; -----------------
(define-struct mão (c1 c2 c3))
;; Um elemento do conjunto Mão é
;; uma estrutura (make-mão (make-carta naipe valor) (make-carta naipe valor) (make-carta naipe valor))
;; onde
;; c1: Carta, é estrutura do tipo Carta (make-carta naipe valor)
;; c2: Carta, é estrutura do tipo Carta (make-carta naipe valor)
;; c3: Carta, é estrutura do tipo Carta (make-carta naipe valor)


;; -----------------
;; TIPO MESA:
;; -----------------
(define-struct mesa (c1 c2 c3 c4))
;; Um elemento do conjunto Mesa é
;; uma estrutura (make-mesa (make-carta naipe valor) (make-carta naipe valor) (make-carta naipe valor) (make-carta naipe valor))
;; onde
;; c1: Carta, é estrutura do tipo Carta (make-carta naipe valor)
;; c2: Carta, é estrutura do tipo Carta (make-carta naipe valor)
;; c3: Carta, é estrutura do tipo Carta (make-carta naipe valor)
;; c4: Carta, é estrutura do tipo Carta (make-carta naipe valor)

;; -----------------
;; TIPO RESULTADO:
;; -----------------
;; Um elemento do conjunto Carta é
(define-struct resultado (carta mensagem))
;; uma estrutura (make-resultado carta mensagem) onde
;; carta: Carta, é estrutura do tipo Carta (make-carta naipe valor)
;; mensagem: String, é uma mensagem que pode ser "Não faço escova." ou "Escova!"


;; CONSTANTES

(define CARTA-PAUS (make-carta "paus" 1))
(define CARTA-ESPADAS (make-carta "espadas" 3))
(define CARTA-COPAS (make-carta "copas" 3))
(define CARTA-OUROS (make-carta "ouros" 3))
(define CARTA-NULA (make-carta "nenhum" 0))


(define MÃO-1 (make-mão CARTA-PAUS CARTA-ESPADAS CARTA-OUROS))
(define MÃO-2 (make-mão CARTA-PAUS CARTA-ESPADAS CARTA-COPAS))
(define MÃO-3 (make-mão CARTA-COPAS CARTA-ESPADAS CARTA-OUROS))
(define MÃO-4 (make-mão CARTA-PAUS CARTA-COPAS CARTA-OUROS))

(define MESA-1 (make-mesa CARTA-PAUS CARTA-ESPADAS CARTA-OUROS CARTA-COPAS))
(define MESA-2 (make-mesa CARTA-PAUS CARTA-ESPADAS CARTA-COPAS CARTA-OUROS))
(define MESA-3 (make-mesa CARTA-COPAS CARTA-ESPADAS CARTA-OUROS CARTA-PAUS))
(define MESA-4 (make-mesa CARTA-PAUS CARTA-COPAS CARTA-OUROS CARTA-ESPADAS))

;; ==============================================================
;;                       QUESTÃO 2
;; ==============================================================
;; soma15?: Carta Carta -> Booleano
;; Objetivo: Dado duas cartas, retorna verdadeiro se a soma dos valores
;;           das duas cartas forem 15, caso contrário retorna falso
;; Exemplos:
;;   (soma15? (make-carta ...) (make-carta ...)) = #true
(define (soma15? c1 c2)
  ;; retorna true se a soma for 15, caso contrario retorna false
  (= (+ (carta-valor c1) (carta-valor c2)) 15)
)

;; TESTES

(check-expect (soma15? (make-carta "paus" 1) (make-carta "paus" 8)) #false)
(check-expect (soma15? (make-carta "paus" 7) (make-carta "paus" 8)) #true)

;; ==============================================================
;;                       QUESTÃO 3
;; ==============================================================
;; soma15: Carta Mesa -> Carta
;; Objetivo: Dada uma carta da mão e uma mesa, devolve a primeira carta da mesa
;;           que soma 15 com a carta informada. Caso nenhuma some 15, então retorna CARTA-NULA
;; Exemplos:
;;   (soma15 (make-mão ...) (make-mesa ...)) = (make-carta "espadas" 8)
(define (soma15 carta mesa)
  (cond
      ;; verifica se a carta informada soma 15 com a primeira carta da mesa
      ;; se sim retorna primeira carta da mesa
      [(boolean=? true (soma15? carta (mesa-c1 mesa))) (mesa-c1 mesa)]
      ;; verifica se a carta informada soma 15 com a segunda carta da mesa
      ;; se sim retorna segunda carta da mesa
      [(boolean=? true (soma15? carta (mesa-c2 mesa))) (mesa-c2 mesa)]
      ;; verifica se a carta informada soma 15 com a terceira carta da mesa
      ;; se sim retorna terceira carta da mesa
      [(boolean=? true (soma15? carta (mesa-c3 mesa))) (mesa-c3 mesa)]
      ;; verifica se a carta informada soma 15 com a quarta carta da mesa
      ;; se sim retorna quarta carta da mesa
      [(boolean=? true (soma15? carta (mesa-c4 mesa))) (mesa-c4 mesa)]
      ;; caso nenhuma das cartas da mesa some 15, entao retorna CARTA-NULA
      [else  CARTA-NULA]
  )
)

;; TESTES

(check-expect (soma15 (make-carta "paus" 10) MESA-1) (make-carta "nenhum" 0))
(check-expect (soma15 CARTA-PAUS MESA-1) (make-carta "nenhum" 0))

;; ==============================================================
;;                       QUESTÃO 4
;; ==============================================================
;; escova?: Carta Mesa -> Boolean
;; Objetivo: Dado uma carta e uma mesa retorna verdadeiro
;;           caso a jogada resulte em escova, caso contrário
;;           retorna falso
;; Exemplos:
;;   (escova?: (make-carta ...) (make-mesa ...)) = #true

(define (escova? carta mesa)
  ;; retorna true se a soma de todas as cartas da mesa + carta é 15
  ;; caso contrario retorna false
    (= 15 (+
           (carta-valor carta)
           (carta-valor (mesa-c1 mesa))
           (carta-valor (mesa-c2 mesa))
           (carta-valor (mesa-c3 mesa))
           (carta-valor (mesa-c4 mesa))))
)


;; TESTES

(check-expect (escova? (make-carta "paus" 1) MESA-1) #false)
(check-expect (escova? (make-carta "paus" 5) MESA-1) #true)

;; ==============================================================
;;                       QUESTÃO 5
;; ==============================================================
;; jogada-escova: Mão Mesa -> String
;; Objetivo: se houver possibilidade de escova, devolve a mensagem (string) "Escova!"
;;           caso contrário devolve a mensagem "Não faço escova."
;; Exemplos:
;;   (jogada-escova (make-mão ...) (make-mesa ...)) = "Escova!"

(define (jogada-escova mão mesa)
  (cond
      ;; 
      [(or
        ;; verifica se cada carta da mao da escova
        ;; caso pelo menos uma das cartas de escova, entao
        ;; retorna a mensagem "Escova!"
        (boolean=? true (escova? (mão-c1 mão) mesa))
        (boolean=? true (escova? (mão-c2 mão) mesa))
        (boolean=? true (escova? (mão-c3 mão) mesa))) "Escova!"]
      ;; caso contrário retorna "Não faço escova."
      [else  "Não faço escova."]
  )
)

;; TESTES

(check-expect (jogada-escova MÃO-1 MESA-1) "Não faço escova.")
(check-expect (jogada-escova (make-mão (make-carta "paus" 5) (make-carta "paus" 2) (make-carta "paus" 3)) MESA-1) "Escova!")

;; ==============================================================
;;                       QUESTÃO 6
;; ==============================================================
;; seleciona-carta: Mão Mesa -> Resultado
;; Objetivo: Dado uma mão e uma mesa, retorna a carta selecionada para jogar
;;             e a mensagem (string) "Escova!", ou "Não faço escova."
;;           Ambas informações são retornadas dentro do tipo estruturado
;;           Resultado
;; Exemplos:
;;   (seleciona-carta (make-mão ...) (make-mesa ...)) = (make-resultado (make-carta "paus" 7) "Escova!")

(define (seleciona-carta mão mesa)
  (cond
      ;; Verificar se cada carta da mao faz escova, se sim retorna a carta da mão e a mensagem "Escova!"
      [(boolean=? true (escova? (mão-c1 mão) mesa)) (make-resultado (mão-c1 mão) "Escova!")]
      [(boolean=? true (escova? (mão-c2 mão) mesa)) (make-resultado (mão-c2 mão) "Escova!")]
      [(boolean=? true (escova? (mão-c3 mão) mesa)) (make-resultado (mão-c3 mão) "Escova!")]
      ;; Se nenhuma carta faz escova, entao verifica cada carta da mao para retornar a primeira
      ;; cartao nao nula, ou seja, a primeira carta que é maior que zero, seguindo a ordem da mão
      [(and
        (boolean=? false (escova? (mão-c1 mão) mesa))
        (> (carta-valor (mão-c1 mão)) 0)) (make-resultado (mão-c1 mão)"Não faço escova.")]
      [(and
        (boolean=? false (escova? (mão-c2 mão) mesa))
        (> (carta-valor (mão-c2 mão)) 0)) (make-resultado (mão-c2 mão)"Não faço escova.")]
      [(and
        (boolean=? false (escova? (mão-c3 mão) mesa))
        (> (carta-valor (mão-c3 mão)) 0)) (make-resultado (mão-c3 mão) "Não faço escova.")]
  )
)

;; TESTES

(check-expect (seleciona-carta MÃO-1 MESA-1) (make-resultado (make-carta "paus" 1) "Não faço escova."))


;; ==============================================================
;;                       QUESTÃO 7
;; ==============================================================
;; desenha-carta: Carta -> Imagem
;; Objetivo: Dado uma carta, se for carta nula retorna empty-image, caso seja
;;           uma carta comum retorna uma imagem representando essa carta
;; Exemplos:
;;   (desenha-carta (make-carta "copas" 5)) = Imagem de uma carta inspirada nos baralhos tradicionais
;;   (desenha-carta (make-carta "nenhum" 0)) = empty-image

;; TESTES
(check-expect (desenha-carta CARTA-NULA) empty-image)

(define (desenha-carta carta)
  (cond
      ;; verifica se é carta-nula, então retorna empty-image
      [(= (carta-valor carta) 0) empty-image]
      ;; caso contrario retorna imagem da carta
      [else (overlay
                (above
                 (text (carta-naipe carta) 18 "white")
                 (text (number->string (carta-valor carta)) 25 "white"))
                (rectangle 60 100 "solid" "black"))
      ]
  )
)
