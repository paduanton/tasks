;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname lista1-AntonioDePaduaSantosJunior-D) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
(require 2htdp/image)

;; ==========================================================
;;                       QUESTÃO 1
;; ==========================================================
;; número-azulejos: Numero Numero Numero-> Numero
;; Obj: Dado a largura e altura de uma parede e lado de um azulejo
;;      devolve a quantidade de azulejos necessários para preencher
;;      a parede.
;; Exemplos:
;;    (número-azulejos 100 100 10) =  100
;;    (número-azulejos 8 10000 20) = 200

(define (número-azulejos largura altura ladoAzulejo)
   (ceiling (/ (* largura altura) (* ladoAzulejo ladoAzulejo))))


;; Testes:

(check-expect (número-azulejos 100 100 10)   100)
(check-expect (número-azulejos 8 10000 20)   200)
(check-expect (número-azulejos 750 250 100)   19)


;; ===========================================================
;;                       QUESTÃO 2
;; ===========================================================
;;  número-azulejos-com-sobra : Numero Numero Numero -> Numero
;; Obj: Dado a largura e altura de uma parede e lado de um azulejo
;;      devolve a quantidade de azulejos necessários para preencher
;;      a parede considerando que se houver necessidade de cortar um
;;      azulejo, somente uma das partes poderá ser utilizada.
;; Exemplos:
;; (número-azulejos-com-sobra 750 250 100) = 24

(define (número-azulejos-com-sobra largura altura ladoAzulejo)
    (* (ceiling (/ largura ladoAzulejo)) (ceiling (/ altura ladoAzulejo))))


;; Testes:

(check-expect (número-azulejos-com-sobra 750 250 100)   24)

;; ============================================================
;;                       QUESTÃO 3
;; ============================================================
;; número-azulejos-com-sobra : Numero Numero Numero -> String
;; Obj: Dado a largura e altura de uma parede e lado de um azulejo
;;      devolve uma string informando em um texto a
;;      quantidade de azulejos necessários para preencher
;;      a parede considerando que se houver necessidade de cortar um
;;      azulejo, somente uma das partes poderá ser utilizada.
;; Exemplos:
;; (número-azulejos-com-sobra 750 250 100) = "O número de azulejos necessários é 24"   

(define (número-azulejos-msg largura altura ladoAzulejo)
   (string-append "O número de azulejos necessários é " (number->string (número-azulejos-com-sobra largura altura ladoAzulejo))))


;; Testes:

(check-expect (número-azulejos-msg 750 250 100) "O número de azulejos necessários é 24")

;; =============================================================
;;                       QUESTÃO 4
;; ============================================================
;; monta-palavra: String String String -> String
;; Obj: Dados 2 palavras, informa a quantidade de letras
;;      de cada palavra somadas
;; Exemplos:
;;   (monta-palavra "A" "B") = "2 letras"
;;   (monta-palavra "guarda" "chuva") = "11 letras"

(define (monta-palavra palavra1 palavra2)
   (string-append (number->string (+ (string-length palavra1) (string-length palavra2))) " letras"))


;; Testes:
 
(check-expect (monta-palavra "A" "B") "2 letras")

;; ===============================================================
;;                       QUESTÃO 5
;; ==============================================================

;; Definição de função/funções:

;; Definições de constantes:

;; ==============================================================
;;                       QUESTÃO 6
;; ==============================================================
;; Minha-imagem: Imagem
;; Exemplos:
;;   A imagem gerada é um dardo de tiro ao alvo

;; gera-circulo-pintado: Numero String -> Imagem
;; Obj: Dados um tamanho e uma cor gera a imagem de circulo pintado desta cor
;; Exemplos:
;;   (gera-circulo-pintado 20 "red") = Images de circulo de tamanho 20 pintado da cor vermelha
(define (gera-circulo-pintado tamanho cor)
   (circle tamanho "solid" cor))

(define constante-circulo-cinza (gera-circulo-pintado 20 "gray"))
(define constante-circulo-vermelho (gera-circulo-pintado 30 "red"))
(define constante-circulo-preto (gera-circulo-pintado 40 "black"))
(define constante-circulo-azul (gera-circulo-pintado 50 "blue"))
(define constante-circulo-laranja (gera-circulo-pintado 60 "orange"))

(define Minha-imagem
         (overlay  constante-circulo-cinza constante-circulo-vermelho
          constante-circulo-preto constante-circulo-azul
          constante-circulo-laranja))

Minha-imagem