# tttm_minimax.py
from .minimax import minimax_move

def utility(state, player):
    """
    Retorna utilidade terminal do ponto de vista de `player`:
      +1 se player vence, -1 se perde, 0 se empate.
    Para estados não-terminais, retorna 0 (neutro), pois em TTTM buscamos a árvore completa.
    """
    if state.is_terminal():
        w = state.winner()  # 'B'/'W'/None
        if w is None:
            return 0.0
        return 1.0 if w == player else -1.0
    return 0.0

def _eval_tttm(state, me):
    # Em TTTM, usamos busca completa (depth=-1); avaliação só é chamada em cortes.
    return utility(state, me)

def make_move(state):
    # Depth = -1 => resolve completamente (minimax com poda alfa-beta)
    return minimax_move(state, depth=-1, eval_fn=_eval_tttm, time_limit=None)
