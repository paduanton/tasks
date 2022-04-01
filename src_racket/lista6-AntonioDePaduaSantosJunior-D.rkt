;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-reader.ss" "lang")((modname lista6-AntonioDePaduaSantosJunior-D) (read-case-sensitive #t) (teachpacks ((lib "image.rkt" "teachpack" "2htdp"))) (htdp-settings #(#t constructor repeating-decimal #f #t none #f ((lib "image.rkt" "teachpack" "2htdp")) #f)))

;; Nome: Antonio de Pádua Santos Júnior
;; Turma: D

;; ============ DEFINIÇÕES DE DADOS ==============
;; -----------------
;; TIPO ALUNO:
;; -----------------
(define-struct aluno (nome prova1 prova2 exerc))
;; Um elemento de Aluno é
;;    (make-aluno n p1 p2 e), onde
;;    n : String, é o nome do aluno
;;    p1: Número, é a nota da prova 1 do aluno
;;    p2: Número, é a nota da prova 2 do aluno
;;    e : Número, é a nota dos exercícios do aluno

;; Exemplos de alunos:

(define ALUNO-1 (make-aluno "Antonio" 8 9 10))
(define ALUNO-2 (make-aluno "Antony" 9 4 2))
(define ALUNO-3 (make-aluno "Antonia" 7 9 3))

;; -----------------
;; TIPO LISTAALUNOS:
;; -----------------
;; Uma ListaAlunos é
;; 1. empty, ou
;; 2. (cons a la), onde
;;     n : Aluno
;;     ln: ListaAluno

;; Exemplos de listas de alunos:

(define LISTA-ALUNOS-1 (cons ALUNO-1 (cons ALUNO-2 (cons ALUNO-3 empty))))

;; =================================================
;;           FUNÇÕES DE CÁLCULO DAS NOTAS
;; =================================================

;; calculaNotas: ListaAlunos -> ListaNúmero
;; obj:  Dada a lista de alunos, devolver a lista de notas finais dos alunos
;; Exemplos e testes:

  ;;      (check-expect   (calculaNotas empty) empty)
 ;;      (check-expect   (calculaNotas L1) (list  7.1 4.3 9.9))
  ;;      (check-expect   (calculaNotas L2) (list 8.9 7.1 4.3 9.9 6.6))
 
(define (calculaNotas @lista)
  (cond
    ;; se a lista estiver vazia, devolver a lista vazia
    [(empty? @lista) empty]
    ;; senao, incluir a nota do primeiro aluno na frente da 
    [else (cons (calculaNotaFinal (first @lista))
                ;; lista de notas dos  alunos do resto da lista de alunos
                (calculaNotas (rest @lista)))]))

;; calculaNotaFinal: Aluno -> Numero
;; obj:Dado um aluno, calcular sua nota final
;; Exemplos e testes:
    ;;    (check-expect (calculaNotaFinal JOÃO) 8.9)
   ;;     (check-expect (calculaNotaFinal MARIA) 7.1)

(define (calculaNotaFinal @a)
  (+ (* (aluno-prova1 @a) 0.4)
     (* (aluno-prova2 @a) 0.5)
     (* (aluno-exerc @a) 0.1)))

;; número->string : Número -> String
;; Dado um número, transforma este número em um string usando um formato com até 2 casas decimais 
;; Exemplos e testes:
        (check-expect (número->string 7.689)  "7.69")
        (check-expect(número->string 10/3)  "3.33")
        (check-expect (número->string 7)  "7.0")
(define (número->string @n)
  (number->string (exact->inexact (/ (round (* @n 100)) 100))))
;; ================================================
;;                 QUESTÃO 1
;; ================================================

;; ============ DEFINIÇÕES DE DADOS ==============
;; -----------------
;; TIPO PAR:
;; -----------------
(define-struct par (nome conceito))
;; Um elemento de Par é
;;    (make-par n c), onde
;;    n : String, é o nome do aluno
;;    c : String, é o conceito do aluno

;; -----------------
;; TIPO LISTAPAR:
;; -----------------
;; Uma ListaPAr é
;; 1. empty, ou
;; 2. (cons p lp), onde
;;     n : Par
;;     ln: ListaPar

;; ============ DEFINIÇÕES DE FUNÇÕES ==============

;; gera-lista-conceitos: ListaAlunos -> ListaPar
;; obj: Dado uma lista de alunos devolve uma lista de pares correspondente a cada aluno

(define (gera-lista-conceitos lista-alunos)
  (cond
    [(empty? lista-alunos ) empty]
    [else (cons (make-par
                 (aluno-nome (first lista-alunos))
                 (cond
                
                   [(>= (calculaNotaFinal (first lista-alunos)) 9) "A99"]
                   
                   [(and (>= (calculaNotaFinal (first lista-alunos)) 7.5)
                        (< (calculaNotaFinal (first lista-alunos)) 9)) "B"]
                   
                   [(and (>= (calculaNotaFinal (first lista-alunos)) 6)
                        (< (calculaNotaFinal (first lista-alunos)) 7.5)) "C"]
                   
                   [else "D"]
                 ))
                 (gera-lista-conceitos (rest lista-alunos)))]))


;; ================================================
;;                 QUESTÃO 2
;; ================================================
;; devolve-conceitos: ListaPares -> ListaStrings
;; obj: Dado uma lista de pares devolve uma lista de strings contendo o conceito de cada par

(define (devolve-conceitos lista-pares)
  (cond
    [(empty? lista-pares) empty]
    [else (cons
           (par-conceito (first lista-pares))
                 (devolve-conceitos (rest lista-pares)))]))

;; (devolve-conceitos (list (make-par "Antonio" "B") (make-par "Antony" "D") (make-par "Antonia" "B")))

;; ================================================
;;                 QUESTÃO 3
;; ================================================
;; filtra-nomes-conceito-A: ListaPares -> ListaStrings
;; obj: Dado uma lista de pares devolve uma lista de strings contendo o nome dos pares que possuem o conceito A

(define (filtra-nomes-conceito-A lista-pares)
  (cond
    [(empty? lista-pares) empty]
    [ else
      (cond
        [(string=? "A" (par-conceito (first lista-pares)))
         (cons (par-nome (first lista-pares)) (filtra-nomes-conceito-A (rest lista-pares)))]
        [else (filtra-nomes-conceito-A (rest lista-pares ))])]))

;; (filtra-nomes-conceito-A (list (make-par "Antonio" "B") (make-par "Antony" "A") (make-par "Antonia" "B")))

;; ================================================
;;                 QUESTÃO 4
;; ================================================
;; filtra-nomes-conceito: ListaPares String -> ListaStrings
;; obj: Dado uma lista de pares e um conceito devolve uma lista de strings contendo o nome dos pares que possuem o respectivo conceito
(define (filtra-nomes-conceito lista-pares conceito)
  (cond
    [(empty? lista-pares) empty]
    [ else
      (cond
        [(string=? conceito (par-conceito (first lista-pares)))
         (cons (par-nome (first lista-pares)) (filtra-nomes-conceito (rest lista-pares) conceito))]
        [else (filtra-nomes-conceito (rest lista-pares ) conceito)])]))

;; (filtra-nomes-conceito (list (make-par "Antonio" "B") (make-par "Antony" "A") (make-par "Antonia" "B")) "C")

;; ================================================
;;                 QUESTÃO 5
;; ================================================
;; gera-imagem-par: Par String -> Imagem
;; obj: Dado um par e uma descricao do conceito, devolve uma image contendo o nome do par, conceito e a descricao do conceito
(define (gera-imagem-par par descricao-conceito)
 (overlay
                (above
                 (text (par-nome par) 18 "white")
                 (text (par-conceito par) 25 "white")
                 (text descricao-conceito 12 "white"))
                (rectangle 150 100 "solid" "black")
                (rectangle 152 102 "solid" "white"))
)

;; gera-porcentagem-conceito: ListaAlunos -> Imagem
;; obj: Dado uma lista de alunos devolve uma imagem contendo um resumo da turma, contendo a porcentagem de alunos que possuem cada conceito
(define (gera-porcentagem-conceito lista-alunos)
                (above
                 (text
                    (string-append
                     "A: "
                     (número->string
                         (/ (* 100 (length (filtra-nomes-conceito (gera-lista-conceitos lista-alunos) "A") ))
                            (length lista-alunos)))
                     "%"
                     ) 25 "black")
                  (text
                    (string-append
                     "B: "
                     (número->string
                         (/ (* 100 (length (filtra-nomes-conceito (gera-lista-conceitos lista-alunos) "B") ))
                            (length lista-alunos)))
                     "%"
                     ) 25 "black")
                  (text
                    (string-append
                     "C: "
                     (número->string
                         (/ (* 100 (length (filtra-nomes-conceito (gera-lista-conceitos lista-alunos) "C") ))
                            (length lista-alunos)))
                     "%"
                     ) 25 "black")
                  (text
                    (string-append
                     "D: "
                     (número->string
                         (/ (* 100 (length (filtra-nomes-conceito (gera-lista-conceitos lista-alunos) "D") ))
                            (length lista-alunos)))
                     "%"
                     ) 25 "black")
                 )
)
;; gera-conceito-aluno : Aluno -> String
;; obj: Dado um aluno devolve o conceito desse aluno 
(define (gera-conceito-aluno aluno)
              (cond
  
                   [(>= (calculaNotaFinal  aluno) 9) "A"]
                  
                   [(and (>= (calculaNotaFinal  aluno) 7.5)
                        (< (calculaNotaFinal  aluno) 9)) "B"]
                  
                   [(and (>= (calculaNotaFinal  aluno) 6)
                        (< (calculaNotaFinal  aluno) 7.5)) "C"]
                  
                   [else "D"]
                 )) 

;; gera-conceito-aluno : ListaAlunos -> Imagem
;; obj: Dado uma lista de alunos de devolve uma imagem contendo a lista de alunos, seus conceitos informando se foram aprovados ou não
(define (gera-resumo-turma lista-alunos)
  (cond
 
    [(empty? lista-alunos) empty-image]
   
    [else (cond
           [(string=?  (gera-conceito-aluno (first lista-alunos)) "A")
             (beside
               (gera-imagem-par (make-par (aluno-nome (first lista-alunos)) "A") "Aprovado")
               (gera-resumo-turma (rest lista-alunos)))
           ]
           [(string=?  (gera-conceito-aluno (first lista-alunos)) "B")
             (beside
               (gera-imagem-par (make-par (aluno-nome (first lista-alunos)) "B") "Aprovado")
               (gera-resumo-turma (rest lista-alunos)))
           ]
           [(string=?  (gera-conceito-aluno (first lista-alunos)) "C")
             (beside
               (gera-imagem-par (make-par (aluno-nome (first lista-alunos)) "C") "Aprovado")
               (gera-resumo-turma (rest lista-alunos)))
           ]
           [(string=?  (gera-conceito-aluno (first lista-alunos)) "D")
             (beside
               (gera-imagem-par (make-par (aluno-nome (first lista-alunos)) "D") "Reprovado")
               (gera-resumo-turma (rest lista-alunos)))
           ]
           [else (gera-resumo-turma (rest lista-alunos)) ])])
 )






(gera-resumo-turma LISTA-ALUNOS-1)
(gera-porcentagem-conceito LISTA-ALUNOS-1)