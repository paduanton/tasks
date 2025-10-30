idab_custom_agent


Bibliotecas necessárias
A implementação usa apenas biblioteca padrão do Python, sem dependências externas.
Requisitos: Python 3.8 ou superior
Módulos usados: math, time, random, collections

Tic-Tac-Toe Misere — Avaliação da poda alfa-beta
Implementação em tttm_minimax.py: minimax com poda alfa-beta e busca completa (depth = -1).
(i) Contra randomplayer: sempre vence ou empata; nunca perde.
(ii) Contra si mesmo: sempre empata (jogo ótimo).
(iii) Contra humano: não perde; empata quando o humano joga perfeitamente.
A poda reduz significativamente nós visitados e mantém decisões ótimas com tempo de resposta abaixo de 0,1s por jogada.

Othello
3.1 Heurísticas implementadas
– Contagem (othello_minimax_count.py): diferença de peças (B−W ou W−B).
– Posicional do kit (othello_minimax_mask.py): soma da máscara EVAL_TEMPLATE (valorizando cantos e bordas).
– Customizada (othello_minimax_custom.py): combinação de Mobilidade, Posição (máscara clássica) e Controle de Cantos.
Fórmula: 5 × Mobilidade + 1 × Posição + 15 × Cantos.

3.2 Critério de parada
Aprofundamento iterativo por tempo: limite de 4,8 segundos por jogada, iniciando em profundidade 3 e aumentando enquanto houver tempo (tournament_agent.py).

3.3 Resultados (item “b” da seção 2.3)
– evaluate_count e evaluate_mask: todos os testes passaram.
– A heurística customizada apresentou melhor desempenho prático por equilibrar mobilidade e cantos.
– Com poda alfa-beta e aprofundamento iterativo, o agente retorna lances competitivos de forma consistente dentro do limite de tempo.

3.4 Implementação para o torneio
tournament_agent.py usa minimax com poda alfa-beta, aprofundamento iterativo (limite de 4,8s) e a função de avaliação evaluate_custom.

Extras
– Agente alternativo com MCTS (mcts.py) implementado para comparação empírica