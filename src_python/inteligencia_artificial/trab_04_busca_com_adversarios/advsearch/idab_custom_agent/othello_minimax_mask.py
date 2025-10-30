# othello_minimax_mask.py
from .minimax import minimax_move

DEPTH = 5  # ajuste aqui

MASK = [
    [100,-20,10, 5, 5,10,-20,100],
    [-20,-50,-2,-2,-2,-2,-50,-20],
    [ 10, -2,  3, 2, 2, 3, -2, 10],
    [  5, -2,  2, 0, 0, 2, -2,  5],
    [  5, -2,  2, 0, 0, 2, -2,  5],
    [ 10, -2,  3, 2, 2, 3, -2, 10],
    [-20,-50,-2,-2,-2,-2,-50,-20],
    [100,-20,10, 5, 5,10,-20,100]
]

def _grid(state):
    return getattr(state.board, "grid", None) or getattr(state.board, "board", None)

def evaluate_mask(state, me):
    g = _grid(state)
    score_me = 0
    score_opp = 0
    for r in range(8):
        for c in range(8):
            if g[r][c] == me:
                score_me += MASK[r][c]
            elif g[r][c] != '.' and g[r][c] != me:
                score_opp += MASK[r][c]
    return float(score_me - score_opp)

def make_move(state):
    return minimax_move(state, depth=DEPTH, eval_fn=evaluate_mask, time_limit=4.8)
