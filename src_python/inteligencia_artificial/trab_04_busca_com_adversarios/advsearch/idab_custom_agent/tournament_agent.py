import time
from .minimax import minimax_move
from .othello_minimax_custom import evaluate_custom

def make_move(state):
    deadline = time.time() + 4.8
    best = None
    depth = 3
    while time.time() < deadline:
        time_left = deadline - time.time()
        if time_left <= 0.15:
            break
        mv = minimax_move(state, depth=depth, eval_fn=evaluate_custom, time_limit=time_left)
        if mv is not None:
            best = mv
        depth += 1
    return best
