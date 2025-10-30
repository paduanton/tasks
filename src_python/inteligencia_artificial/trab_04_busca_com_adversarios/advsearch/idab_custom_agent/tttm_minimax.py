# tttm_minimax.py
from .minimax import minimax_move

def _utility_terminal(state, me):
    w = state.winner()  # 'B'/'W'/None
    if w is None:
        return 0.0
    return 1.0 if w == me else -1.0

def _eval_tttm(state, me):
    # Em TTTM (3x3), podemos resolver completo; se cortar, retorna 0 neutro.
    if state.is_terminal():
        return _utility_terminal(state, me)
    return 0.0

def make_move(state):
    # Busca completa (misère é pequeno); sem limite de tempo necessário.
    return minimax_move(state, depth=-1, eval_fn=_eval_tttm, time_limit=None)
