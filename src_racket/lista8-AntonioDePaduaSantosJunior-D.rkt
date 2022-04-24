;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-lambda-reader.ss" "lang")((modname lista8-AntonioDePaduaSantosJunior-D) (read-case-sensitive #t) (teachpacks ((lib "image.rkt" "teachpack" "2htdp"))) (htdp-settings #(#t constructor repeating-decimal #f #t none #f ((lib "image.rkt" "teachpack" "2htdp")) #f)))
;; Nome: Antonio de Pádua Santos Júnior

;; ==========================================================
;; QUESTÃO 1
;; ==========================================================

(define-struct pessoa (nome ano olhos altura pai mãe))

;; Um elemento do conjunto Pessoa é
;; 1. empty, representando a falta de informação ou
;; 2. (make-pessoa n a o a p m)
;; onde:
;; n : String, representa o nome da indivíduo
;; a : Número, representa o ano de nascimento do indivíduo
;; o : String, representa a cor dos olhos do indivíduo
;; a : Número, representa a altura do indivíduo
;; p : Pessoa, representa o pai do indivíduo
;; m : Pessoa, representa a mãe do indivíduo

;; 
(define PESSOA-ARVORE-GENEALOGICA-1
  (make-pessoa "Gustavo" 2022 "blue" 1.68
      (make-pessoa "Gustavo" 2005 "green" 1.78 empty empty)
      (make-pessoa "Henrique" 2005 "black" 2
                   (make-pessoa "Carlos" 1986 "brown"  1.85 empty empty)
                   (make-pessoa "Betina" 1987 "blue" 1.55
                               (make-pessoa "Juliano" 1968 "brown" 1.98
                                            (make-pessoa "Antonio" 1946 "black"  1.80 empty empty)
                                            (make-pessoa "Natália" 1947 "brown" 1.65
                                                         (make-pessoa "Ana" 1926 "blue"  1.55 empty empty)
                                                         (make-pessoa "Mauro" 1926 "brown"  1.80 empty empty)
                                             )
                               )
                               empty
                   )
      )
  )
)

(define PESSOA-ARVORE-GENEALOGICA-2
  (make-pessoa "Gustavo" 2022 "blue" 1.68
      (make-pessoa "Gustavo" 2005 "green" 1.78 empty empty)
      (make-pessoa "Henrique" 2005 "blue" 2
                   (make-pessoa "Carlos" 1986 "brown"  1.85
                                (make-pessoa "Ana" 1966 "brown"  1.55 empty empty)
                                (make-pessoa "Mauro" 1966 "brown"  1.80 empty empty)
                   )
                   (make-pessoa "Betina" 1987 "blue" 1.55
                               (make-pessoa "Juliano" 1968 "brown" 1.98
                                            (make-pessoa "Antonio" 1946 "blue"  1.80 empty empty)
                                            (make-pessoa "Natália" 1947 "black" 1.65 empty empty)
                               )
                               empty
                   )
      )
  )

)

;; ==========================================================
;; QUESTÃO 2
;; ==========================================================
;; altura-arvore-gen : Pessoa -> Numero
;; Obj: Dado uma pessoa retorna a altura da árvore genealógica dela
;;      (distância da raiz até o nodo mais distante conhecido)
(define (altura-arvore-gen pessoa)
 (cond
   ;; se a arvore for vazia retorna -1
   [(empty? pessoa) -1]
   ;; caso contrário soma a altura do primeira pessoa até a altura mais distante da arvore
   [else (+ 1 
          (max (altura-arvore-gen (pessoa-mãe pessoa)) (altura-arvore-gen (pessoa-pai pessoa))))]))

;; Exemplos / Testes
(check-expect (altura-arvore-gen PESSOA-ARVORE-GENEALOGICA-1) 5)
(check-expect (altura-arvore-gen PESSOA-ARVORE-GENEALOGICA-2) 4)

;; ==========================================================
;; QUESTÃO 3
;; ==========================================================
;; lista-ancestrais-olhos : Pessoa String -> ListaDeStrings
;; Obj: Dado uma pessoa e uma string contendo a cor dos olhos, verifica os ancestrais e
;;      retorna uma lista de string contendo o nome das pessoas que possuem os olhos da cor em questão
(define (lista-ancestrais-olhos pessoa olhos)
  (cond
    ;; se a arvore for vazia retorna empty
    [(empty? pessoa) empty]
    [else
      (cond
        ;; caso contrário verificar se os olhos da pessoa tem essa cor de olhos
        ;; se tiver insere a pessoa na lista e verifica a cor dos olhos dos ancestrais dos
        ;; pais da pessoa, e insere na lista caso tenham a cor de olhos em questão
        [(string=? olhos (pessoa-olhos pessoa))
         (cons (pessoa-nome pessoa)
               (append (lista-ancestrais-olhos (pessoa-pai pessoa) olhos)
                       (lista-ancestrais-olhos (pessoa-mãe pessoa) olhos)))]
        ;; caso a pessoa não tenha a cor de olhos em questão os olhos dos pais da pessoa
        [else (append
               (lista-ancestrais-olhos (pessoa-pai pessoa) olhos)
               (lista-ancestrais-olhos (pessoa-mãe pessoa) olhos))])]))

;; Exemplos / Testes
(check-expect (lista-ancestrais-olhos PESSOA-ARVORE-GENEALOGICA-1 "blue") (list "Gustavo" "Betina" "Ana"))
(check-expect (lista-ancestrais-olhos PESSOA-ARVORE-GENEALOGICA-2 "black") (list "Natália"))


;; ==========================================================
;; QUESTÃO 4
;; ==========================================================
;; pessoas-mesmos-olhos? : Pessoa Pessoa -> Boolean
;; Obj: Dado duas pessoas, verifica se as duas possuem a mesma cor de olhos,
;;      se sim, retorna true, caso contrário retorna false
(define (pessoas-mesmos-olhos? pessoa1 pessoa2)
  (cond
    ;; se a pessoa 1 E pessoa 2 forem empty (não existrem), retorna false
      [(and
           (empty? pessoa1)
           (empty? pessoa2)) false]
      ;; se a pessoa 1 OU pessoa 2 for empty (não existir), retorna false
      [(or
           (empty? pessoa1)
           (empty? pessoa2)) false]
      ;; se a pessoa 1 e pessoa 2 tiverem a mesma cor de olhos retorna true
      [(string=? (pessoa-olhos pessoa1) (pessoa-olhos pessoa2)) true]
      ;; caso todas as condições anteriores deem false, retorna false por padrão
      ;; (duas pessoas terem a cor dos olhos diferentes, por exemplo)
      [else false]
    )
)

;; Exemplos / Testes
(check-expect (pessoas-mesmos-olhos? (make-pessoa "Ana" 1926 "blue"  1.55 empty empty) (make-pessoa "João" 1926 "blue"  1.55 empty empty)) true)
(check-expect (pessoas-mesmos-olhos? (make-pessoa "Ana" 1926 "blue"  1.55 empty empty) (make-pessoa "João" 1926 "black"  1.55 empty empty)) false)

;; casal-mesmos-olhos? : Pessoa -> Boolean
;; Obj: Dado uma pessoa, verifica os ancestrais e
;;      retorna true caso agum casal possua a mesma cor de olhos e
;;      false, caso contrário retorna false
(define (casal-mesmos-olhos? pessoa)
  (cond
    ;; se a arvore for vazia retorna empty
    [(empty? pessoa) false]
    [else
      (cond
        ;; verifica se a mãe e o pessoa tenho a mesma cor de olhos, se tiverem retorna true
        [(pessoas-mesmos-olhos? (pessoa-mãe pessoa) (pessoa-pai pessoa)) true]
        [else
         ;; caso contrário verifica os olhos dos casais do resto da arvore
         ;; pelo lado de mãe e pai
         (cond
           [(or
                (casal-mesmos-olhos? (pessoa-mãe pessoa))
                (casal-mesmos-olhos? (pessoa-pai pessoa))) true]
           ;; caso nenhum destes seja verdadeiro retorna false
           [else false]
    )])]))


;; Exemplos / Testes
(check-expect (casal-mesmos-olhos? PESSOA-ARVORE-GENEALOGICA-1) false)
(check-expect (casal-mesmos-olhos? PESSOA-ARVORE-GENEALOGICA-2) true)

;; ==========================================================
;; QUESTÃO 5
;; ==========================================================
;; casal-mesmos-olhos : Pessoa -> ListaDeStrings
;; Obj: Dado uma pessoa, verifica os ancestrais e
;;      retorna o nome de cada pessoa do casal que possui mesma cor de olhos ou
;;      retorna "Não tem", caso contrário
(define (casal-mesmos-olhos pessoa)
  (cond
    ;; verificar se algum casal tem a mesma cor de olhos
    [(casal-mesmos-olhos? pessoa)
      (cond
        ;; se tiver retorna uma string com o nome do casal que possui a mesma cor de olhos
        [(string=? (pessoa-olhos (pessoa-mãe pessoa))
                   (pessoa-olhos (pessoa-pai pessoa)))
         (string-append (pessoa-nome (pessoa-mãe pessoa)) " e " (pessoa-nome (pessoa-pai pessoa)))]
        ;; caso contrário verifica os casais com mesmos olhos no restos da arvore por parte de pai e mãe
        [(string=? (casal-mesmos-olhos (pessoa-mãe pessoa)) "Não tem") (casal-mesmos-olhos (pessoa-pai pessoa))]
        [else (casal-mesmos-olhos (pessoa-mãe pessoa))])]
    ;; caso nenhum casal tenha a mesma cor de olhos, retorna a string "Não tem"
    [else "Não tem"]))

;; Exemplos / Testes

(check-expect (casal-mesmos-olhos PESSOA-ARVORE-GENEALOGICA-2) "Mauro e Ana")
(check-expect (casal-mesmos-olhos PESSOA-ARVORE-GENEALOGICA-1) "Não tem")

;; ==========================================================
;; QUESTÃO 6
;; ==========================================================

(define-struct nó (id conteúdo esq dir))

; Um elemento do conjunto ABP (Árvore Binária de Pesquisa) pode ser:
;; 1. empty , representando a falta de informação, ou
;; 2. (make-nó id c e d)
;; onde:
;; id : Número, representa o identificador do nó
;; c : String, representa o conteúdo do nó
;; e : ABP, representa a sub-árvore da esquerda e contém apenas nós com identificadores menores que id
;; d : ABP, representa a sub-árvore da direita e contém apenas nós com identificadores maiores que id

(define JUMANJI (make-nó 10 "Jumanji" empty empty))
(define IRREVERSSÍVEL (make-nó 7 "Irreverssível" empty empty))
(define BROOKLYN-99 (make-nó 6 "Brooklyn 99" empty empty))
(define MATRIX (make-nó 2 "Matrix" empty empty))
(define CORRA (make-nó 1 "Corra!" empty MATRIX))
(define FRIENDS (make-nó 9 "Friends" IRREVERSSÍVEL JUMANJI))
(define CORINGA (make-nó 3 "Coringa" CORRA BROOKLYN-99))
(define BATMAN (make-nó 5 "Batman" CORINGA FRIENDS))
(define HP (make-nó 12 "Harry Potter" empty empty))
(define SUPERMAN (make-nó 11 "Superman" BATMAN HP))

(define CATALOGO SUPERMAN)


;; Resposta dissertativa:
;; Não é ABP.
;; Para ser ABP, deveríamos mudar os ids de
;; - 5 para 6
;; - 

;; ==================================================================
;; FUNÇÓES PARA VISUALIZAÇÃO DE ÁRVORES
;; ==================================================================


;; ==================================================================
;; VISUALIZAÇÃO DE ÁRVORES GENEALÓGICAS
;; ==================================================================

;; mostra-arvore-gen: Pessoa -> Imagem
;; Obj: dada uma árvore genealógica, gera uma visualização dela em forma de imagem.
(define (mostra-arvore-gen ag)
  (cond
    ;; se a arvore estiver vazia, devolve a imagem do nodo vazio
    [(empty? ag) (color-frame "Dark Gray" empty-node)]
    ;;se não, 
    [else (color-frame "Dark Gray"
                       (above/align "middle"
                                    ;; coloca a imagem do nodo acima
                                    (mostra-pessoa ag)
                                    ;; das imagens das subárvores, lado a lado, com um frame em volta de cada subárvore
                                    (beside/align "top"
                                                  (mostra-sub-arvore (pessoa-pai ag) "PAI" mostra-arvore-gen)
                                                  (mostra-sub-arvore (pessoa-mãe ag) "MÃE" mostra-arvore-gen))))]))

;; mostra-sub-arvore: Pessoa String -> Imagem
;; obj: dada uma árvore genealógica, um título e uma função que gera a visualização de uma árvore,
;; gera uma visualização dela com um título acima
(define (mostra-sub-arvore ag t fun-mostra-arvore)
  (color-frame "Dark Gray" (above/align "middle" (titulo t) (fun-mostra-arvore ag))))

;; mostra-pessoa: Pessoa -> Imagem
;; obj: dado uma pessoa, gera uma imagem com suas informações
(define (mostra-pessoa p)
  (overlay/align "middle" "middle"
          ;; conteúdo do nodo:
          (above/align "middle"
                       (margem 20)
                       (text (pessoa-nome p) 20 "Crimson") ;; nome
                       (margem 10)
                       (beside (mostra-olhos (pessoa-olhos p)) ;; olhos
                               (text " " 20 "white")
                               (above/align "left"
                                            (text (number->string (pessoa-ano p)) 14 "Navy") ;; ano
                                            (text (string-append (number->string (pessoa-altura p)) " cm") 14 "Navy"))) ;; altura
                       (margem 10)) ;; altura
          (rectangle 100 80 "solid" "white")))

;; titulo: String -> Imagem
;; obj: dada uma string, gera uma imagem com essa string
(define (titulo n)
  (above (margem 5)
         (text n 10 "Navy")
         (margem 5)))

;; empty-node: -> Imagem
;; obj: retorna a imagem do nodo vazio
(define empty-node
  (overlay/align "middle" "middle"
          ;; conteúdo do nodo vazio:
          (text "EMPTY" 10 "Dark Gray") ;; codigo
          ;; frame:
          (rectangle 50 40 "solid" "white")))

;; nova-cor: String -> String
;; obj: transforma a cor tradicional em tons mais bonitos pra desenhar
(define (nova-cor c)
  (cond [(string=? c "blue") "Deep Sky Blue"]
        [(string=? c "green") "Aquamarine"]
        [(string=? c "brown") "Saddle Brown"]
        [else c]))

;; mostra-olhos: String -> Imagem
;; obj: dada uma cor, desenha um olho dessa cor
(define (mostra-olhos cor)
  (overlay
   (circle 5 "solid" "black")
   (circle 15 "solid" (nova-cor cor))))

;; margem: Número -> Imagem
;; obj: dado um número, cria uma imagem vazia de acordo com o número dado
(define (margem size) (text "" size "white"))


;; ==================================================================
;; VISUALIZAÇÃO DE ABPs
;; ==================================================================

;; mostra-arvore-gen: ABP -> Imagem
;; Obj: dada uma ABP, gera uma visualização dela em forma de imagem.
(define (mostra-abp abp)
  (cond
        ;; se a abp estiver vazia, devolve a imagem do nodo vazio
        [(empty? abp) (color-frame "Dark Gray" empty-node)]
        ;;se não, coloca a imagem do nodo acima
        [else (color-frame "Dark Gray"
                           (above/align "middle"
                                        (mostra-nodo abp)
                                        ;; das imagens das subárvores, lado a lado, com um frame em volta de cada subárvore
                                        (beside/align "top"
                                                      (mostra-sub-arvore (nó-esq abp) "ESQ" mostra-abp)
                                                      (mostra-sub-arvore (nó-dir abp) "DIR" mostra-abp))))]))

;; mostra-nodo: ABP -> Imagem
;; obj: dado uma ABP, gera uma imagem com as informações do nó raíz
(define (mostra-nodo f)
  (overlay/align "middle" "middle"
          ;; conteúdo do nodo:
          (above/align "middle" (margem 20)
                       (text (number->string (nó-id f)) 20 "Crimson") (margem 10)
                       (text (nó-conteúdo f) 16 "Crimson") (margem 10))
          (rectangle 100 80 "solid" "white")))


;; nó-valido? : Nó  -> Boolean
;; obj: Dado um nó retorna true se e o id do nó esquerda é menor que id do nó atual e o id do nó da direita é maior que o id do nó atual
;;      caso contrário retorna false

(define (nó-valido? nó)
  (cond
      [(empty? nó) false]
      [(or
           (empty? (nó-esq nó))
           (empty? (nó-dir nó))) false]
      [(and
           (empty? (nó-esq nó))
           (empty? (nó-dir nó))) false]
      [(and (> (nó-id (nó-dir nó)) (nó-id nó))
          (< (nó-id (nó-esq nó)) (nó-id nó))) true]
      [else false]
    )
)

;; é-abp? : Nó  -> Boolean
;; obj: Dado um nó retorna true se o nó for uma árvore binária de pesquisa, caso contrário retorna false

(define (é-abp? nó)
  (cond
    [(empty? nó) false]
    [else
      (cond
           [(and
                (nó-valido? nó)
                (nó-valido? (nó-dir nó))
                (nó-valido? (nó-esq nó))
                (é-abp? (nó-esq nó))
                (é-abp? (nó-dir nó))) true]
           [else false]
    )]))

;; Exemplos / Testes

(check-expect (é-abp?  HP) false)
(check-expect (é-abp?  CATALOGO) false)
