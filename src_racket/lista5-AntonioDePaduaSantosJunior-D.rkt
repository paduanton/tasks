;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-reader.ss" "lang")((modname lista5-AntonioDePaduaSantosJunior-D) (read-case-sensitive #t) (teachpacks ((lib "image.rkt" "teachpack" "2htdp"))) (htdp-settings #(#t constructor repeating-decimal #f #t none #f ((lib "image.rkt" "teachpack" "2htdp")) #f)))

;; Nome: Antonio de Pádua Santos Júnior
;; Turma: D

;; ==========================================================
;; QUESTÃO 1
;; ==========================================================

;; Um elemento do conjunto Carta é
;;   (make-carta n v)     onde
;;   n : String, é o naipe da carta, que pode ser "copas", "ouros", "espadas" ou "paus"
;;   v : Número, é o valor da carta, que pode ser qualquer inteiro entre 1 e 10
(define-struct carta (naipe valor))

;; CONSTANTES

(define CARTA-NULA (make-carta "nenhum" 0))
(define CARTA-PAUS (make-carta "paus" 6))
(define CARTA-ESPADAS (make-carta "espadas" 1))
(define CARTA-COPAS (make-carta "copas" 2))
(define CARTA-OUROS (make-carta "ouros" 6))

(define MÃO-1 (cons CARTA-NULA (cons CARTA-PAUS (cons CARTA-COPAS empty))))
(define MÃO-2 (cons CARTA-PAUS (cons CARTA-ESPADAS (cons CARTA-COPAS empty))))
(define MÃO-3 (cons CARTA-COPAS (cons CARTA-OUROS (cons CARTA-PAUS empty))))


(define MESA-1 (cons CARTA-OUROS (cons CARTA-PAUS (cons CARTA-COPAS empty))))
(define MESA-2 (cons CARTA-PAUS (cons CARTA-ESPADAS (cons CARTA-COPAS empty))))
(define MESA-3 (cons CARTA-COPAS (cons CARTA-OUROS (cons CARTA-PAUS empty))))


;; ===========================================================
;; QUESTÃO 2
;; ===========================================================

;; soma15?: Carta Carta -> Booleano
;; obj: dadas 2 cartas, verifica se o valor delas somado é 15.
;; ex:
;;  (soma15? $CARTA3O $CARTA5C) -> #false
;;  (soma15? $CARTA10O $CARTA5C) -> #true)
;;  (soma15? $CARTA5C $CARTA10O) -> #true)
;;  (soma15? $CARTA7E $CARTA8E) -> #true)

(define (soma15? c1 c2)
  ;; retorna true se a soma for 15, caso contrario retorna false
  (= (+ (carta-valor c1) (carta-valor c2)) 15)
)
(check-expect (soma15? (make-carta "ouros" 3) (make-carta "copas" 5)) #false)
(check-expect (soma15? (make-carta "ouros" 10) (make-carta "copas" 5)) #true)
(check-expect (soma15? (make-carta "copas" 5) (make-carta "ouros" 10)) #true)
(check-expect (soma15? (make-carta "espadas" 7) (make-carta "espadas" 8)) #true)


;; soma15: Carta Mesa -> Carta
;; Objetivo: Dada uma carta da mão e uma mesa, devolve a primeira carta da mesa
;;           que soma 15 com a carta informada. Caso nenhuma some 15, então retorna CARTA-NULA
;; Exemplos:
;;   (soma15 (make-carta ...) (cons (make-carta ...)) empty)) = (make-carta "espadas" 8)
;;   (soma15 (make-carta ...) (cons (make-carta ...)) empty)) = (make-carta "ouros" 8)

(define (soma15 carta mesa)
  (cond
    ;; se mesa estiver vazia retorna carta nula
    [(empty? mesa) CARTA-NULA]
    ;; caso contrario executa esse bloco
    [else (cond
            ;; caso a primeira carta da mesa some 15 com a carta informada, retorna a primeira carta da mesa
            [(boolean=? (soma15? carta (first mesa)) true) (first mesa)]
            ;; caso contrario executa a funcao novamente no resto da mesa
            [else (soma15 carta (rest mesa)) ])]))

;; TESTES

(check-expect (soma15 (make-carta "espadas" 9) MESA-1) (make-carta "ouros" 6))
(check-expect (soma15 CARTA-PAUS MESA-2) (make-carta "nenhum" 0))

;; ============================================================
;; QUESTÃO 3
;; ============================================================
;; soma-mesa Mesa -> Numero
;; Objetivo: Dada uma mesa, retorna a soma de todas as suas cartas.
;; Exemplos:
;;   (soma-mesa (cons (make-carta ...)) empty)) = 10
;;   (soma-mesa (cons (make-carta ...)) empty)) =16

(define (soma-mesa mesa)
  (cond
    ;; se a mesa esta vazia, devolver zero
    [(empty? mesa) 0]
    ;; caso contrario soma o valor de cada carta da mesa
    [else (+ (carta-valor (first mesa))
             (soma-mesa (rest mesa)))]))

;; TESTES

(check-expect  (soma-mesa MESA-2) 9)
(check-expect  (soma-mesa MESA-1) 14)

;; escova?: Carta Mesa -> Boolean
;; Objetivo: Dado uma carta e uma mesa retorna verdadeiro
;;           caso a jogada resulte em escova, caso contrário
;;           retorna falso
;; Exemplos:
;;   (escova?: (make-carta ...) (cons (make-carta ...))) = #true
;;   (escova?: (make-carta ...) (cons (make-carta ...))) = #false
(define (escova? carta mesa)
  (cond
    ;; se a mesa for vazia entao retorna false
    [(empty? mesa) false]
    ;; caso contrario executa esse bloco
    [else
     ;; se a soma da carta e da mesa for 15, entao retorna true,
     ;; caso contrario retorna false
     (= (+ (carta-valor carta) (soma-mesa mesa)) 15)]))


(escova? CARTA-OUROS MESA-1)
(check-expect  (escova? CARTA-OUROS MESA-2) true)
;; =============================================================
;; QUESTÃO 4
;; =============================================================
;; jogada-escova: Mão Mesa -> String
;; Objetivo: se houver possibilidade de escova, devolve a mensagem (string) "Escova!"
;;           caso contrário devolve a mensagem "Não faço escova."
;; Exemplos:
;;   (jogada-escova (cons (make-carta ...)) (cons (make-carta ...))) = "Escova!"
;;   (jogada-escova (cons (make-carta ...)) (cons (make-carta ...))) = "Não faço escova."

(define (jogada-escova mão mesa)
  (cond
    ;; se a mesa for vazia, entao retorna "Não faço escova."
    [(empty? mesa) "Não faço escova."]
    ;; se a mão for vazia, entao retorna "Não faço escova."
    [(empty? mão) "Não faço escova."]
    ;; caso a mesa e nem a mao sejam vazias entao executa esse bloco
    [else
            (cond
            ;; se a primeira carta da mão faz escova, entao retorna "Escova!"
            [(boolean=? (escova? (first mão) mesa) true) "Escova!"]
            ;; caso contrario executa a funcao no resto da mão
            [else (jogada-escova (rest mão) mesa) ])]))

;; (jogada-escova MÃO-3 MESA-1)


;; ==============================================================
;; QUESTÃO 5
;; ==============================================================

(define-struct jogada (carta msg))
;; Um elemento do conjunto Jogada é
;;   (make-jogada c m)     onde
;;   c : Carta, é a carta selecionada na jogada
;;   m : String, é uma mensagem, que pode ser "Escova!" ou "Não faço escova."


;; verifica-escova Mão Mesa -> Carta
;; Objetivo: Dado uma mão e uma mesa que fazem escova, retorna a primeira
;;           carta da mão que faz escova com a mesa
;; Exemplos:
;;   (verifica-escova (cons (make-carta ...)) (cons (make-carta ...))) = (make-carta "ouros" 5)
;;   (verifica-escova (cons (make-carta ...)) (cons (make-carta ...))) = (make-carta "paus" 6)

(define (verifica-escova mão mesa)
  (cond
    ;; se a primeira carta da mão somar 15 com a mesa, retorna a carta 
    [(= (+ (carta-valor (first mão)) (soma-mesa mesa)) 15) (first mão)]
    ;; caso contrario roda a funcao de novo no resto da mao
    [else (verifica-escova (rest mão) mesa)]))


;; verifica-carta-nula Mão Mesa -> Carta
;; Objetivo: Dado uma mão retorna a primeira carta que não for nula
;; Exemplos:
;;   (verifica-escova (cons (make-carta ...)) (cons (make-carta ...))) = (make-carta "ouros" 5)
;;   (verifica-carta-nula (cons (make-carta ...)) (cons (make-carta ...))) = (make-carta "paus" 6)

(define (verifica-carta-nula mão)
  (cond
    ;; verifica se a primeira carta da mão é nula, então retorna a carta
    [(> (carta-valor (first mão)) 0) (first mão)]
    ;; caso contrario roda a funcao novamente no resto da mao
      [else (verifica-carta-nula (rest mão))]))

;; seleciona-carta: Mão Mesa -> Jogada
;; Objetivo: Dado uma mão e uma mesa, retorna a carta selecionada para jogar
;;             e a mensagem (string) "Escova!", ou "Não faço escova."
;;           Ambas informações são retornadas dentro do tipo estruturado
;;           Jogada
;; Exemplos:
;;   (seleciona-carta (cons (make-carta ...)) (cons (make-carta ...))) = (make-jogada (make-carta "espadas" 1) "Escova!")
;;   (seleciona-carta (cons (make-carta ...)) (cons (make-carta ...))) = (make-jogada (make-carta "paus" 6) "Não faço escova.")

(define (seleciona-carta mão mesa)
  (make-jogada
   (cond
     ;; se a mão faz escova com mesa, então retorna a carta que fez escova
     [(string=? (jogada-escova mão mesa) "Escova!") (verifica-escova mão mesa)]
     ;; caso contrario retorna a primeira carta não nula
     [else (verifica-carta-nula mão)])
   (jogada-escova mão mesa)))


;; TESTES
(check-expect (seleciona-carta MÃO-2 MESA-1) (make-jogada (make-carta "espadas" 1) "Escova!"))
(check-expect (seleciona-carta MÃO-1 MESA-1) (make-jogada (make-carta "paus" 6) "Não faço escova."))
