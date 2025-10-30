# mcts.py
# Implementação genérica de MCTS (UCT) para estados do kit.
# API esperada do estado (GameState): is_terminal(), legal_moves(), next_state(move), winner(), player

import time
import math
import random
from collections import defaultdict

class MCTS:
    def __init__(self, c_ucb: float = 1.4142):
        self.c = c_ucb
        self.Ns = defaultdict(int)       # N(s): visitas ao estado
        self.Nsa = defaultdict(int)      # N(s,a): visitas à aresta
        self.Wsa = defaultdict(float)    # W(s,a): soma de recompensas
        self.children = {}               # s -> lista de ações (expandidas)
        self._root_key = None
        self._root_player = None

    def _key(self, state):
        return str(state)  # assume __str__ determinístico

    def search(self, root_state, time_limit: float = 4.8):
        self._root_key = self._key(root_state)
        self._root_player = root_state.player
        deadline = time.time() + time_limit

        while time.time() < deadline:
            self._simulate(root_state)

        # escolhe a ação com maior N(s,a)
        acts = self.children.get(self._root_key)
        if acts is None:
            acts = list(root_state.legal_moves())  # <-- garante lista
        if not acts:
            return None

        best_a, best_n = None, -1
        for a in acts:
            nsa = self.Nsa[(self._root_key, a)]
            if nsa > best_n:
                best_n, best_a = nsa, a
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
                # expandir nó
                acts = list(curr.legal_moves())     # <-- garante lista
                self.children[skey] = acts
                break  # faz rollout a partir de curr
            if not acts:
                # sem ações (passa/terminal)
                break

            # seleção por UCB1
            best_a, best_ucb = None, -1e18
            for a in acts:
                nsa = self.Nsa[(skey, a)]
                if nsa == 0:
                    ucb = 1e9  # força explorar
                else:
                    q = self.Wsa[(skey, a)] / nsa
                    ucb = q + self.c * math.sqrt(math.log(self.Ns[skey] + 1) / nsa)
                if ucb > best_ucb:
                    best_ucb, best_a = ucb, a

            if best_a is None:
                break  # defesa

            path.append((skey, best_a))
            curr = curr.next_state(best_a)

        # ROLLOUT
        reward = self._rollout(curr)

        # RETROPROPAGAÇÃO
        for skey, a in path:
            self.Ns[skey] += 1
            self.Nsa[(skey, a)] += 1
            self.Wsa[(skey, a)] += reward

    def _rollout(self, state):
        curr = state
        steps = 0
        while not curr.is_terminal() and steps < 200:
            acts = list(curr.legal_moves())          # <-- garante lista
            if not acts:
                break
            curr = curr.next_state(random.choice(acts))
            steps += 1

        w = curr.winner()  # 'B'/'W'/None
        if w is None:
            return 0.0
        return 1.0 if w == self._root_player else -1.0


def make_move(state):
    mcts = MCTS()
    return mcts.search(state, time_limit=4.8)
