Antonio de Pádua Santos Júnior - Cartão Matrícula: 00318785 - Turma B
Vitor Alexandre Arguilar - Cartão Matrícula: 00344617 - Turma A

1. Geral
A implementação utiliza apenas bibliotecas padrão do Python, sem dependências externas.p

2. Avaliação da poda alfa-beta no Tic-Tac-Toe misere

A implementação do tttm_minimax.py usa minimax com poda alfa-beta e profundidade total (depth = -1).

(i) Contra o randomplayer, o agente sempre vence ou empata — nunca perde.
(ii) Quando joga contra si mesmo, o resultado é sempre empate, confirmando jogo ótimo.
(iii) Contra um jogador humano, o agente não perde, apenas empata nas melhores jogadas.

A poda alfa-beta reduziu significativamente o número de nós avaliados, mantendo decisões ótimas e rápidas (<0,1s por jogada).

3. Othello

Heurística customizada
A heurística usada combina três fatores:

Mobilidade (minhas jogadas – jogadas do oponente),

Posição (valores da máscara posicional clássica, valorizando cantos e bordas),

Controle de cantos (bônus para posse dos quatro cantos).

A fórmula final é:
5 × Mobilidade + 1 × Posição + 15 × Cantos

Critério de parada
O agente usa aprofundamento iterativo limitado por tempo (máx. 4,8s por jogada).
Começa com profundidade 3 e aumenta enquanto houver tempo, garantindo o melhor resultado possível dentro do limite.

Resultados
Nos testes, as funções evaluate_count e evaluate_mask passaram todos os casos.
A heurística customizada teve desempenho superior, equilibrando bem abertura, meio e fim de jogo, explorando cantos e mobilidade com eficiência.

Implementação no torneio
O tournament_agent.py usa minimax com poda alfa-beta e aprofundamento iterativo com a função evaluate_custom.
A cada jogada, o agente busca até o tempo máximo e retorna o melhor movimento encontrado.

Extras
Foi implementado também um agente alternativo com MCTS