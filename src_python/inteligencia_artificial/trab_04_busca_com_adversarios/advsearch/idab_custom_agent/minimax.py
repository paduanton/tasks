# minimax.py
import math
import time

def minimax_move(state, depth, eval_fn, time_limit=None):
    """
    Retorna a melhor jogada (x,y) para o jogador de state.player usando minimax com poda alfa-beta.
    depth >= 1: profundidade fixa
    depth == -1: busca até terminal
    eval_fn(state, me): heurística (usada em cortes não-terminais)
    time_limit: segundos (float) para toda a decisão; se None, ignora.
    """
    start = time.time()
    me = state.player  # quem maximiza no estado raiz

    def timeout():
        return (time_limit is not None) and (time.time() - start >= time_limit)

    def is_cutoff(s, d):
        if timeout():
            return True
        if s.is_terminal():
            return True
        if d == 0:
            return True
        return False

    def terminal_or_eval(s):
        if s.is_terminal():
            w = s.winner()
            if w is None:
                return 0.0
            return 1.0 if w == me else -1.0
        return eval_fn(s, me)

    def max_value(s, d, alpha, beta):
        if is_cutoff(s, d):
            return None, terminal_or_eval(s)
        v = -math.inf
        best_move = None
        moves = s.legal_moves()
        for mv in moves:
            child = s.next_state(mv)
            _, score = min_value(child, d-1 if d > 0 else -1, alpha, beta)
            if score > v:
                v, best_move = score, mv
            alpha = max(alpha, v)
            if v >= beta or timeout():
                break
        return best_move, v

    def min_value(s, d, alpha, beta):
        if is_cutoff(s, d):
            return None, terminal_or_eval(s)
        v = math.inf
        best_move = None
        moves = s.legal_moves()
        for mv in moves:
            child = s.next_state(mv)
            _, score = max_value(child, d-1 if d > 0 else -1, alpha, beta)
            if score < v:
                v, best_move = score, mv
            beta = min(beta, v)
            if v <= alpha or timeout():
                break
        return best_move, v

    move, _ = max_value(state, depth, -math.inf, math.inf)
    return move
