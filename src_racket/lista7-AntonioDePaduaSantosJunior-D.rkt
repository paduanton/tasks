;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-lambda-reader.ss" "lang")((modname lista7-AntonioDePaduaSantosJunior-D) (read-case-sensitive #t) (teachpacks ((lib "draw.rkt" "teachpack" "htdp") (lib "image.rkt" "teachpack" "2htdp"))) (htdp-settings #(#t constructor repeating-decimal #f #t none #f ((lib "draw.rkt" "teachpack" "htdp") (lib "image.rkt" "teachpack" "2htdp")) #f)))
;; Nome: Antonio de Pádua Santos Júnior

;; ==============================================================
;; 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
;; ==============================================================
;; ============================
;; DEFINIÇÕES DE TIPOS DE DADOS
;; ============================
;;   TIPO ELIPSE:
(define-struct elipse (lado1 lado2 cor nome))
;; Um elemento de Elipse tem o formato
;;    (make-elipse  l1 l2 c n), onde
;;     l1: Número, é a largura da elipse;
;;     l2: Número, é a altura da elipse;
;;     c : String, é a cor da elipse;
;;     n : String, é o nome da elipse.
(define E1 (make-elipse 30 60 "red" "E1"))
(define E2 (make-elipse 40 40 "green" "E2"))

;;   TIPO TRIANGULO:
(define-struct triangulo (lado cor nome))
;; Um elemento de Triangulo tem o formato
;;    (make-triangulo  l c n), onde
;;     l: Número, é o lado do triângulo;
;;     c : String, é a cor do triângulo;
;;     n : String, é o nome do triângulo.
(define T1 (make-triangulo 30  "blue" "T1"))
(define T2 (make-triangulo 40  "red" "T2"))

;;   TIPO ESTRELA:
(define-struct estrela (lado cor nome))
;; Um elemento de Estrela tem o formato
;;    (make-estrela  r c n), onde
;;     r : Número, é o lado da estrela (na realidade, o lado do pentágono que circunscreve a estrela);
;;     c : String, é a cor da estrela;
;;     n : String, é o nome da estrela.
(define S1 (make-estrela 20  "pink" "S1"))
(define S2 (make-estrela 30  "red" "S2"))

;; Uma Forma pode ser
  ;; 1. uma Elipse, ou
  ;; 2. um  Triangulo, ou
  ;; 3. uma Estrela

;; Uma ListaDeFormas é
;; 1. vazia (empty), ou
;; 2. (cons f lf), onde
;;     f : Forma
;;    lf : ListaDeFormas

;; Uma ListaDeString é
;; 1. vazia (empty), ou
;; 2. (cons f lf), onde
;;     f : String
;;    lf : ListaDeString

;; Constantes do tipo ListaDeFormas:
  (define L1 (cons S1 (cons T1 empty)))
  (define L2 (cons S1 (cons S2 (cons T1 (cons T2 (cons E1 (cons E2 empty)))))))
  (define L3 (cons T1 (cons T1 (cons E2 (cons T1 (cons E1 (cons T2 (cons E1 empty))))))))
  (define L4 (cons S2 (cons S2 (cons S2 (cons T2 empty)))))

;; =====================
;; DEFINIÇÕES DE FUNÇÕES
;; =====================

;; desenha : Forma -> Imagem
;; Dada uma forma, gera uma imagem desta forma.
;; Exemplos:
;;     (desenha S1) desenha uma estrela rosa de lado 20
;;     (desenha (T2) desenha um triângulo vermeho de lado 40 
  (define (desenha f)
    (cond
      [(elipse? f)    (ellipse (elipse-lado1 f) (elipse-lado2 f) "solid" (elipse-cor f))]
      [(triangulo? f) (triangle  (triangulo-lado f)  "solid" (triangulo-cor f))]
      [(estrela? f)   (star    (estrela-lado f)    "solid" (estrela-cor f))]))
;; Testes:
   (check-expect (desenha S1) (star 20 "solid" "pink"))
   (check-expect (desenha E2) (ellipse 40 40 "solid" "green"))

;; ==============================================================
;; A A A A A A A A A ==> lista-elipses
;; ==============================================================
;; lista-elipses : ListaFormas -> ListaFormas
;; Obj: Dada uma lista de formas, devolve uma lista com todas as elipses
;;      da lista original.
;; Exemplos:
;;  (lista-elipses L4) =  empty
;;  (lista-elipses L2) = (cons E1 (cons E2 empty))

(define (lista-elipses lf)
  (filter elipse? lf)
)

;; Testes:

(check-expect (lista-elipses L1) '())
(check-expect (lista-elipses L2) (list (make-elipse 30 60 "red" "E1") (make-elipse 40 40 "green" "E2")))
(check-expect (lista-elipses L3) (list (make-elipse 40 40 "green" "E2") (make-elipse 30 60 "red" "E1") (make-elipse 30 60 "red" "E1")))
(check-expect (lista-elipses L4) '())

;; ==============================================================
;; B B B B B B B B  ==> lista-nomes-elipses
;; ==============================================================
;; lista-nomes-elipses : ListaDeFormas -> ListaDeString
;; Obj: Dada uma lista de formas, devolve uma lista com os nomes de todas as elipses
;;      da lista original.
;; Exemplos:
;;  (lista-nomes-elipses L4) =  empty
;;  (lista-nomes-elipses L2) = (cons "E1" (cons "E2" empty))

(define (lista-nomes-elipses lf)
  (map elipse-nome (filter elipse? lf))
)

;; Testes:

(check-expect (lista-nomes-elipses L1) '())
(check-expect (lista-nomes-elipses L2) (list "E1" "E2"))
(check-expect (lista-nomes-elipses L3) (list "E2" "E1" "E1"))
(check-expect (lista-nomes-elipses L4) '())

;; ==============================================================
;; C C C C C C C C  ==> lista-elipses-img
;; ==============================================================
;; lista-elipses-img : ListaDeFormas -> Imagem
;; Obj: Dada uma lista de formas, devolve uma imagem com todos
;;       os elipses da lista original, na ordem inversa na qual
;;       eles aparecem na lista
;; Exemplo: (lista-elipses-img L2) desenha uma elipse verde ao lado de uma elipse vermelha 
(define (lista-elipses-img lf)
  (foldl
   beside
   empty-image
   (map desenha (filter elipse? lf))
  )
)

;; Testes:

(check-expect (lista-elipses-img L1) empty-image)
(check-expect (lista-elipses-img L2) (beside (ellipse 40 40 "solid" "green") (ellipse 30 60 "solid" "red")))
(check-expect (lista-elipses-img L3) (beside (ellipse 30 60 "solid" "red") (ellipse 30 60 "solid" "red") (ellipse 40 40 "solid" "green")))
(check-expect (lista-elipses-img L4) empty-image)

;; ==============================================================
;; D D D D D D D D ==> soma-raios-estrelas
;; ==============================================================
;; soma-lados-estrelas : ListaDeFormas -> Numero
;; Obj:Dada uma lista de formas, devolve a soma dos tamanhos dos lados das estrelas da lista.
;; Exemplo: (soma-lados-estrelas L2) = 50

(define (soma-lados-estrelas lf)
  (foldl
   +
   0
   (map estrela-lado (filter estrela? lf))
  )
)
;; Testes:

(check-expect (soma-lados-estrelas L1) 20)
(check-expect (soma-lados-estrelas L2) 50)
(check-expect (soma-lados-estrelas L3) 0)
(check-expect (soma-lados-estrelas L4) 90)

;; ==============================================================
;; E E E E E E E E ==> desenha-lista-formas
;; ==============================================================
;; desenha-lista-formas: ListaDeFormas -> Imagem
;; Obj: Dada uma lista de formas, monta uma imagem com todas as formas lado a lado,
;; na mesma ordem na qual elas aparecem na lista.
;; Exemplos:
;;  (desenha-lista-formas L3)  desenha lado a lado, nesta ordem: 
;;                             dois triângulos azuis, uma elipse verde, um triângulo azul,
;;                             uma elipse vermelha, um triângulo vermelho e outra elipse vermelha.
;;  (desenha-lista-formas L2)  desenha lado a lado, nesta ordem: uma estrela rosa, uma estrela vermelha,
;;                             um triângulo azul, um triângulo vermelho, uma elipse vermelha e uma elipse verde.
(define (desenha-lista-formas lf)
  (foldr
   beside
   empty-image
   (foldr
    cons
    empty
    (map desenha lf)
   )
  )
)
;; Testes:

(check-expect
 (desenha-lista-formas (list (make-elipse 20 40 "pink" "S1") (make-elipse 30 60 "blue" "T1")))
 (beside (ellipse 20 40 "solid" "pink") (ellipse 30 60 "solid" "blue")))

(check-expect
 (desenha-lista-formas (list (make-estrela 20 "pink" "S1") (make-triangulo 30 "blue" "T1")))
 (beside (star 20 "solid" "pink") (triangle 30 "solid" "blue")))

(check-expect
 (desenha-lista-formas (list (make-triangulo 20 "pink" "S1") (make-triangulo 30 "blue" "T1")))
 (beside (triangle 20 "solid" "pink") (triangle 30 "solid" "blue")))

(check-expect
 (desenha-lista-formas (list (make-estrela 60 "pink" "S1") (make-triangulo 30 "blue" "T1")))
 (beside (star 60 "solid" "pink") (triangle 30 "solid" "blue")))

;; ==============================================================
;; 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2
;; ==============================================================


;; ============ DEFINIÇÕES DE DADOS ==============
(define-struct aplicativo (nome tamanho aval rede?))
;; Um elemento de Aplicativo é
;;    (make-aplicativo n t a r ), onde
;;    n : String, é o nome do aplicativo
;;    t : Número, é a o tamanho que o aplicativo ocupa na memória
;;    a : Número, é a nota de avaliação do aplicativo (entre 0 e 5)
;;    r : Booelano, indica se o aplicativo precisa ou não de rede para executar  (se for #t precisa de rede)

;; Constantes do tipo Aplicativo

(define A1 (make-aplicativo "Google" 35 4 true))
(define A2 (make-aplicativo "Amazon" 4 0 true))
(define A3 (make-aplicativo "Facebook" 15 5 false))
(define A4 (make-aplicativo "Tinder" 15 4.5 false))
(define A5 (make-aplicativo "Get Ninjas" 15 3.5 true))

;; Uma ListaDeAplicativos é
;; 1. empty, ou
;; 2. (cons a la), onde
;;     a : Aplicativo
;;     la: ListaDeAplicativos

;; Constantes do tipo ListaDeAplicativos
(define LA1 (cons A1 (cons A2 (cons A3 (cons A4 empty)))))
(define LA2 (cons A2 (cons A1 (cons A5 (cons A4 empty)))))
(define LA3 (cons A1 (cons A4 empty)))
(define LA4 (cons A1 (cons A3 (cons A4 empty))))

;; =========================================================
;; A A A A A A A A A A A A A A A A A A A A A A A A A A A A A
;; =========================================================
;; filtra-nota-min? Aplicativo -> Boolean
;; Obj: Dado um aplicativo retorna true se a avaliação dele é 0
;;      e false caso contrário
(define (filtra-nota-min? aplicativo)
  (= 0 (aplicativo-aval aplicativo))
)

;; Exemplos/Testes

(check-expect (filtra-nota-min? A1) false)
(check-expect (filtra-nota-min? A2) true)

;; filtra-rede? Aplicativo -> Boolean
;; Obj: Dado um aplicativo retorna true se ele precisa de rede
;;      e false caso contrário
(define (filtra-rede? aplicativo)
  (boolean=? true (aplicativo-rede? aplicativo))
)

;; Exemplos/Testes


(check-expect (filtra-rede? A1) true)
(check-expect (filtra-rede? A4) false)

;; filtra-nota-max? Aplicativo -> Boolean
;; Obj: Dado um aplicativo retorna true se a avaliação dele é 5
;;      e false caso contrário
(define (filtra-nota-max? aplicativo)
  (= 5 (aplicativo-aval aplicativo))
)

;; Exemplos/Testes

(check-expect (filtra-nota-max? A1) false)
(check-expect (filtra-nota-max? A3) true)

;; filtra-otimo? Aplicativo -> Boolean
;; Obj: Dado um aplicativo retorna true se a avaliação dele
;;      é maior ou igual 4.5 ou false caso contrário
(define (filtra-otimo? aplicativo)
  (<= 4.5 (aplicativo-aval aplicativo))
)

;; Exemplos/Testes

(check-expect (filtra-otimo? A1) false)
(check-expect (filtra-otimo? A3) true)
;; filtra-otimo? Aplicativo -> Boolean
;; Obj: Dado um aplicativo retorna true se a avaliação dele
;;      é maior ou igual 4.5 e funciona sem rede ou retorna false
;;      caso contrário
(define (filtra-otimo-sem-rede? aplicativo)
  (cond
      ;; se a avaliacao do aplicativo é maior ou igual 4.5 ou não usa rede, retorna true
     [(and
        (<= 4.5 (aplicativo-aval aplicativo))
        (boolean=? false (aplicativo-rede? aplicativo))) true]
      ;; caso contrario retorna falso
      [else false]
  )
)
;; Exemplos/Testes

(check-expect (filtra-otimo-sem-rede? A1) false)
(check-expect (filtra-otimo-sem-rede? A3) true)
;; =========================================================
;; B B B B B B B B B B B B B B B B B B B B B B B B B B B B B 
;; =========================================================
;; filtra-otimos ListaDeAplicativos -> ListaDeStrings
;; Obj: Dado uma lista de aplicativos uma lista com os nomes
;;       daqueles que possuem nota maior ou igual a 4.5
(define (filtra-otimos lista-aplicativos)
  (map aplicativo-nome (filter filtra-otimo? lista-aplicativos))
)

;; Exemplos/Testes

(check-expect (filtra-otimos LA1) (list "Facebook" "Tinder"))
(check-expect (filtra-otimos LA3) (list "Tinder"))

;; =========================================================
;; C C C C C C C C C C C C C C C C C C C C C C C C C C C C C 
;; =========================================================
;; filtra-otimos-sem-rede ListaDeAplicativos -> ListaDeStrings
;; Obj: Dado uma lista de aplicativos uma lista com os nomes
;;       daqueles que possuem nota maior ou igual a 4.5 e não
;;       precisam de rede para funcionar
(define (filtra-otimos-sem-rede lista-aplicativos)
  (map aplicativo-nome (filter filtra-otimo-sem-rede? lista-aplicativos))
)

;; Exemplos/Testes

(check-expect (filtra-otimos-sem-rede LA1) (list "Facebook" "Tinder"))
(check-expect (filtra-otimos-sem-rede LA3) (list "Tinder"))

;; =========================================================
;; D D D D D D D D D D D D D D D D D D D D D D D D D D D D D
;; =========================================================
;; nota-media-aplicativos ListaDeAplicativos -> Numero
;; Obj: Dado uma lista de aplicativos retorna a média aritmética
;;       das avaliações deles

(define (nota-media-aplicativos lista-aplicativos)
  (/ (foldl
      +
      0
      (map aplicativo-aval lista-aplicativos)
      )
     (length lista-aplicativos))
)

;; Exemplos/Testes

(check-expect (nota-media-aplicativos LA1) 3.375)
(check-expect (nota-media-aplicativos LA4) 4.5)

;; =========================================================
;; E E E E E E E E E E E E E E E E E E E E E E E E E E E E E
;; =========================================================
;; filtra-lista-aplicativos ListaDeAplicativos Função -> ListaDeAplicativos
;; Obj: Dado uma lista de aplicativos e uma função, retorna uma lista de aplicativos
;;       que foram filtrados pela função recebida como parametro

(define (filtra-lista-aplicativos lista-aplicativos filtro)
  (cond
    [(empty? lista-aplicativos) empty]
    [(filtro (first lista-aplicativos))
     (cons (first lista-aplicativos)
           (filtra-lista-aplicativos (rest lista-aplicativos) filtro))]
    [else (filtra-lista-aplicativos (rest lista-aplicativos) filtro)]))

;; Exemplos/Testes

(check-expect (filtra-lista-aplicativos LA1 filtra-rede?) (list (make-aplicativo "Google" 35 4 #true) (make-aplicativo "Amazon" 4 0 #true)))
(check-expect (filtra-lista-aplicativos LA1 filtra-nota-max?) (list (make-aplicativo "Facebook" 15 5 #false)))
(check-expect (filtra-lista-aplicativos LA1 filtra-nota-min?) (list (make-aplicativo "Amazon" 4 0 #true)))