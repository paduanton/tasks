# othello_minimax_count.py
from .minimax import minimax_move

DEPTH = 5  # ajuste aqui se quiser

def _counts(state):
    # Adapte se seu board tiver método próprio (ex.: state.board.count_disks('B')).
    nb = nw = 0
    grid = getattr(state.board, "grid", None) or getattr(state.board, "board", None)
    for row in grid:
        for cell in row:
            if cell == 'B': nb += 1
            elif cell == 'W': nw += 1
    return nb, nw

def evaluate_count(state, me):
    nb, nw = _counts(state)
    mine = nb if me == 'B' else nw
    opp  = nw if me == 'B' else nb
    return float(mine - opp)

def make_move(state):
    return minimax_move(state, depth=DEPTH, eval_fn=evaluate_count, time_limit=4.8)
