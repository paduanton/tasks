import math
import time

def minimax_move(state, depth, eval_fn, time_limit=None):
    start = time.time()
    me = state.player

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

    def evaluate(s):
        return eval_fn(s, me)

    def max_value(s, d, alpha, beta):
        if is_cutoff(s, d):
            return None, evaluate(s)
        v = -math.inf
        best_move = None
        for mv in s.legal_moves():
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
            return None, evaluate(s)
        v = math.inf
        best_move = None
        for mv in s.legal_moves():
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
