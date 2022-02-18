;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname lista2-AntonioDePaduaSantosJunior-D) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; ==========================================================
;;                       QUESTÃO 1
;; ==========================================================
;; movimenta-personagem: Simbolo > String
;; Obj: Dado um simbolo de entrada, retorna o comando correspondente ao
;;      símbolo informado.
;; Exemplos:
;;     (movimenta-personagem 'w) = "Andando para frente"
;;     (movimenta-personagem 'a) = "Andando para esquerda"
;;     (movimenta-personagem 's) = "Andando para tras"
;;     (movimenta-personagem 'd) = "Andando para direita"
;;     (movimenta-personagem 'k) = "Parado"

(define (movimenta-personagem ação)
  (cond
      ;; se ação for igual a 'w retorna a string "Andando para frente"
      [(symbol=? ação 'w)  "Andando para frente"]
      ;; se ação for igual a 'w retorna a string "Andando para esquerda"
      [(symbol=? ação 'a)  "Andando para esquerda"]
      ;; se ação for igual a 'w retorna a string "Andando para tras"
      [(symbol=? ação 's)  "Andando para tras"]
      ;; se ação for igual a 'w retorna a string "Andando para direita"
      [(symbol=? ação 'd)  "Andando para direita"]
      ;; caso a  ação seja diferente de 'w, 'a, 's e 'd então retorna a string "Parado"
      [else  "Parado"]
  )
)

;; Testes:

(check-expect (movimenta-personagem 'w)   "Andando para frente")
(check-expect (movimenta-personagem 'a)   "Andando para esquerda")
(check-expect (movimenta-personagem 's)   "Andando para tras")
(check-expect (movimenta-personagem 'd)   "Andando para direita")
(check-expect (movimenta-personagem 'k)   "Parado")




;; ==========================================================
;;                       QUESTÃO 2
;; ==========================================================
;; esta-dentro?: Numero Numero Numero Numero Numero -> Boolean
;; Obj: Recebe o centro de uma circunferencia, raio do círculo e
;;      o dados de um ponto no plano cartesiano. Então retorna um
;;      valor verdadeiro ou falso informando se o ponto informado
;;      está dentro da circunferência ou não.
;; Exemplos:
;;   (esta-dentro? 0 0 5 2 3) = #true
;;   (esta-dentro? 3 5 4 6 1) = #false
;;   (esta-dentro? 3 5 5 6 1) = #true

(define (esta-dentro? xc yc r xp yp)
  (cond
      ;; retorna falso e a distancia entre os dois pontos for maior que o raio
      [(> (calcula-distancia-ponto-cartesiano xc xp yc yp) r)  #false]
      ;; return true se a distancia entre dois pontos for menor ou igual ao raio
      [else  #true]
  )
)

;; calcula-distancia-ponto-cartesiano: Numero Numero Numero Numero -> Numero
;; Obj: Recebe quatro numeros refentes ao pontos xa, xb, ya, yb de dois pontos
;;      no plano cartesiano e retorna a distancia entre eles.
;;   (calcula-distancia-ponto-cartesiano 6 3 5 1) = 5
(define (calcula-distancia-ponto-cartesiano xa xb ya yb)
  (sqrt (+ (expt (- xb xa) 2) (expt (- yb ya) 2)))
)


;; Testes:
(check-expect (esta-dentro? 3 5 5 6 1)   #true)
(check-expect (esta-dentro? 3 5 4 6 1)   #false)
(check-expect (esta-dentro? 3 5 5 6 1)   #true)



;; ==========================================================
;;                       QUESTÃO 3
;; ==========================================================
;; esta-dentro?-v2: Numero Numero Numero Numero Numero -> Boolean
;; Obj: Recebe o centro de uma circunferencia, raio do círculo e
;;      o dados de um ponto no plano cartesiano. Então retorna um
;;      valor verdadeiro ou falso informando se o ponto informado
;;      está dentro da circunferência ou não.
;; Exemplos:
;;   (esta-dentro?-v2 0 0 5 2 3) = #true
;;   (esta-dentro?-v2 3 5 4 6 1) = #false
;;   (esta-dentro?-v2 3 5 5 6 1) = #true

(define (esta-dentro?-v2 xc yc r xp yp)
    ;; retorna valor verdadeiro se a distancia dos pontos for menor ou igual ao raio
    ;; caso seja maior retorna falso
    (<= (calcula-distancia-ponto-cartesiano xc xp yc yp) r)
)


;; Testes:
(check-expect (esta-dentro?-v2 3 5 5 6 1)   #true)
(check-expect (esta-dentro?-v2 3 5 4 6 1)   #false)
(check-expect (esta-dentro?-v2 3 5 5 6 1)   #true)
(check-expect (esta-dentro?-v2 1 1 2 2 2)   #true)
(check-expect (esta-dentro?-v2 1 1 2 2 4)   #false)
(check-expect (esta-dentro?-v2 1 1 2 1 3)   #true)

;; ==========================================================
;;                       QUESTÃO 4
;; ==========================================================
;; gasto-mes: Numero Numero Numero Numero -> String
;; Obj: Recebe o valor do salario, aluguel, conta de luz e conta de
;;      internet, retorna uma string informando quantos contas
;;      vão poder ser pagas.
;; Exemplos:
;;   (gastos-mes 1000 5400 9400 3300) =  "Neste mês, foi possível pagar 0 conta(s)."
;;   (gastos-mes 1000 5400 400 300) =  "Neste mês, foi possível pagar 2 conta(s)."
;;   (gastos-mes 1000 500 9400 3300) =  "Neste mês, foi possível pagar 1 conta(s)."
;;   (gastos-mes 1000 400 200 700)  = "Neste mês, foi possível pagar 2 conta(s)."
;;   (gastos-mes 100000 5400 9400 3300) =  "Neste mês, foi possível pagar 3 conta(s)."


(define (gastos-mes salario aluguel luz internet)
    (cond
      ;; se o salario for maior ou igual que a soma de todas contas, então foi possivel pagar 3 contas
      [(>= salario (+ aluguel luz internet)) (gera-resposta 3)]
      ;; se o salario for maior ou igual a soma do aluguel e luz ou aluguel e internet ou internet e luz
      ;; então foi possivel pagar 2 contas
      [(or (>= salario (+ aluguel luz))
           (>= salario (+ aluguel internet))
           (>= salario (+ internet luz))) (gera-resposta 2)]
      ;; se o salario for maior ou igual a luz, internet ou aluguel então foi possivel pagar 1 conta
      [(or (>= salario luz)
           (>= salario internet)
           (>= salario aluguel)) (gera-resposta 1)]
      ;; caso nenhuma das condições acima seja verdadeira, então não foi possível pagar nenhuma conta
      [else (gera-resposta 0)]
    )
)

;; gera-resposta: Numero -> String
;; Obj: Recebe um numero qualquer e substitui na o valor na seguinte frase:
;;      "Neste mês, foi possível pagar x conta(s)."
;;      onde x é o numero informado.
;; Exemplos:
;;   (gera-resposta 1) = "Neste mês, foi possível pagar 1 conta(s)."
(define (gera-resposta numero)
  (string-append "Neste mês, foi possível pagar " (number->string numero) " conta(s).")
)

;; Testes:
(check-expect (gastos-mes 100000 5400 9400 3300)   "Neste mês, foi possível pagar 3 conta(s).")
(check-expect (gastos-mes 1000 400 200 700)   "Neste mês, foi possível pagar 2 conta(s).")
(check-expect (gastos-mes 1000 500 9400 3300)   "Neste mês, foi possível pagar 1 conta(s).")
(check-expect (gastos-mes 1000 5400 400 300)   "Neste mês, foi possível pagar 2 conta(s).")
(check-expect (gastos-mes 1000 5400 9400 3300)   "Neste mês, foi possível pagar 0 conta(s).")





;; ==========================================================
;;                       QUESTÃO 5
;; ==========================================================
;; max-tres Numero Numero Numero -> Numero
;; Obj: Recebe 3 numeros e retorna o maior deles
;; Exemplos:
;;   (max-tres 1 2 3) =  3
;;   (max-tres 5 4 3) =  5
;;   (max-tres 1 8 3) =  8

(define (max-tres numero1 numero2 numero3)
    (cond
      [
       ;; numero1 é maior que numero2
       (> numero1 numero2)
         (cond
           ;; se numero1 é maior que numero2 e numero3, entao numero1 é o maior
           [(> numero1 numero3) numero1]
           ;; se numero1 é maior que numero2 e menor ou igual que numero3, entao retorna numero3
           [else numero3]
         )
      ]
      [
       ;; numero2 é maior que numero1
       (> numero2 numero1)
         (cond
           ;; se numero2 é maior que numero1 e numero3, entao numero2 é o maior
           [(> numero2 numero3) numero2]
           ;; se numero2 é maior que numero1 e menor ou igual que numero3, entao retorna numero3
           [else numero3]
         )
      ]
      [
       ;; numero3 é maior que numero1
       (> numero3 numero1)
         (cond
           ;; se numero3 é maior que numero1 e maior que numero2, entao numero3 é o maior
           [(> numero3 numero2) numero3]
           ;; se numero3 é maior que numero1 e menor ou igual que numero2, entao retorna numero2
           [else numero2]
         )
      ]
      ;; se nenhuma das condições acima forem validas, entao os 3 números
      ;; são iguais, então retorna qualquer um deles
      [else numero1]
    )
)

;; Testes:

(check-expect (max-tres 4 4 4)  4)
(check-expect (max-tres 6 2 3)  6)
(check-expect (max-tres 6 2 7)  7)
(check-expect (max-tres 1 3 2)  3)
(check-expect (max-tres 1 4 5)  5)
(check-expect (max-tres 1 2 3)  3)
(check-expect (max-tres 1 6 4)  6)
