from .minimax import minimax_move

def utility(state, player):
    if state.is_terminal():
        w = state.winner()
        if w is None:
            return 0.0
        return 1.0 if w == player else -1.0
    return 0.0

def _eval_tttm(state, me):
    return utility(state, me)

def make_move(state):
    return minimax_move(state, depth=-1, eval_fn=_eval_tttm, time_limit=None)
