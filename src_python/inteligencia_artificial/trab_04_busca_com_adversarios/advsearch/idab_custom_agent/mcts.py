# mcts.py
# Implementação genérica de MCTS (UCT) para estados do kit.
# API esperada do estado (GameState): is_terminal(), legal_moves(), next_state(move), winner(), player
# Sem dependências externas.

import time
import math
import random
from collections import defaultdict

class MCTS:
    def __init__(self, c_ucb: float = 1.4142):
        self.c = c_ucb
        # Tabelas: visitas e ganhos “do ponto de vista do jogador raiz”
        self.Ns = defaultdict(int)       # N(s): visitas ao estado
        self.Nsa = defaultdict(int)      # N(s,a): visitas à aresta
        self.Wsa = defaultdict(float)    # W(s,a): soma de recompensas
        self.children = {}               # s -> lista de ações (expandidas)
        self._root_key = None
        self._root_player = None

    # Chave de estado (usa str para simplicidade)
    def _key(self, state):
        # Se o GameState tiver __str__/__repr__ determinístico, use:
        return str(state)

    def search(self, root_state, time_limit: float = 4.8):
        self._root_key = self._key(root_state)
        self._root_player = root_state.player
        deadline = time.time() + time_limit
        # Loop de iterações até o tempo acabar
        while time.time() < deadline:
            self._simulate(root_state)
        # Escolhe melhor ação pelo maior N(s,a)
        acts = self.children.get(self._root_key, root_state.legal_moves())
        if not acts:
            return None
        best_a = None
        best_n = -1
        for a in acts:
            nsa = self.Nsa[(self._root_key, a)]
            if nsa > best_n:
                best_n = nsa
                best_a = a
        return best_a

    def _simulate(self, state):
        path = []
        curr = state
        # SELEÇÃO + EXPANSÃO
        while True:
            skey = self._key(curr)
            if curr.is_terminal():
                break
            acts = self.children.get(skey)
            if acts is None:
                # Expande nó
                acts = curr.legal_moves()
                self.children[skey] = acts
                break  # vai simular a partir daqui
            # SELEÇÃO por UCB1
            if not acts:
                # Nó sem ações (passo?), trata como terminal
                break
            best_a = None
            best_ucb = -1e18
            for a in acts:
                nsa = self.Nsa[(skey, a)]
                if nsa == 0:
                    ucb = 1e9  # força explorar
                else:
                    q = self.Wsa[(skey, a)] / nsa
                    ucb = q + self.c * math.sqrt(math.log(self.Ns[skey] + 1) / nsa)
                if ucb > best_ucb:
                    best_ucb = ucb
                    best_a = a
            path.append((skey, best_a))
            curr = curr.next_state(best_a)

        # SIMULAÇÃO (playout aleatório) a partir de curr
        reward = self._rollout(curr)

        # RETROPROPAGAÇÃO
        # reward é do ponto de vista do jogador raiz (self._root_player)
        for skey, a in path:
            self.Ns[skey] += 1
            self.Nsa[(skey, a)] += 1
            self.Wsa[(skey, a)] += reward

    def _rollout(self, state):
        curr = state
        # Política aleatória simples até terminal (limite de passos para segurança)
        steps = 0
        while not curr.is_terminal() and steps < 200:
            acts = curr.legal_moves()
            if not acts:
                break
            curr = curr.next_state(random.choice(acts))
            steps += 1
        # Recompensa +1 vitória do jogador raiz, -1 derrota, 0 empate
        w = curr.winner()  # 'B'/'W'/None
        if w is None:
            return 0.0
        return 1.0 if w == self._root_player else -1.0


def make_move(state):
    """
    Interface de agente para o servidor: decide jogada via MCTS.
    """
    mcts = MCTS()
    return mcts.search(state, time_limit=4.8)
