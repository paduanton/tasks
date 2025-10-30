from .minimax import minimax_move

DEPTH = 5
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
CORNERS = [(0,0),(0,7),(7,0),(7,7)]

def _grid(state):
    return getattr(state.board, "grid", None) or getattr(state.board, "board", None)

def _opp(me):
    return 'W' if me == 'B' else 'B'

def _positional(state, me):
    g = _grid(state)
    sm = so = 0
    for r in range(8):
        for c in range(8):
            if g[r][c] == me:
                sm += MASK[r][c]
            elif g[r][c] != '.' and g[r][c] != me:
                so += MASK[r][c]
    return sm - so

def _corner_control(state, me):
    g = _grid(state)
    me_cnt = opp_cnt = 0
    for r,c in CORNERS:
        if g[r][c] == me:
            me_cnt += 1
        elif g[r][c] != '.' and g[r][c] != me:
            opp_cnt += 1
    return 25 * (me_cnt - opp_cnt)

def _mobility(state, me):
    my_moves = len(state.legal_moves())
    try:
        opp = _opp(me)
        opp_moves = len(state.legal_moves_for(opp))
    except Exception:
        opp_moves = 0
    return my_moves - opp_moves

def evaluate_custom(state, me):
    if state.is_terminal():
        w = state.winner()
        if w is None:
            return 0.0
        return 1.0 if w == me else -1.0
    w_mob = 5.0
    w_pos = 1.0
    w_cor = 15.0
    return (
        w_mob * _mobility(state, me) +
        w_pos * _positional(state, me) +
        w_cor * _corner_control(state, me)
    )

def make_move(state):
    return minimax_move(state, depth=DEPTH, eval_fn=evaluate_custom, time_limit=4.8)
