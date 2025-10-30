from .minimax import minimax_move

DEPTH = 5  # ajuste livre

# máscara do kit (EVAL_TEMPLATE) — NÃO ALTERAR
EVAL_TEMPLATE = [
    [100, -30, 6, 2, 2, 6, -30, 100],
    [-30, -50, 1, 1, 1, 1, -50, -30],
    [  6,   1, 1, 1, 1, 1,   1,   6],
    [  2,   1, 1, 3, 3, 1,   1,   2],
    [  2,   1, 1, 3, 3, 1,   1,   2],
    [  6,   1, 1, 1, 1, 1,   1,   6],
    [-30, -50, 1, 1, 1, 1, -50, -30],
    [100, -30, 6, 2, 2, 6, -30, 100]
]

# ---------- helpers ----------

def _cell_owner(cell):
    if cell is None:
        return None
    if isinstance(cell, int):
        if cell == 1:  return 'B'
        if cell == -1: return 'W'
        return None
    if isinstance(cell, str):
        s = cell.strip()
        if not s: return None
        ch = s[0].upper()
        if ch in ('B','X'): return 'B'
        if ch in ('W','O'): return 'W'
        if ch in ('.','_'): return None
        return None
    for attr in ("owner", "player", "color", "char"):
        v = getattr(cell, attr, None)
        if v is not None:
            who = _cell_owner(v)
            if who in ('B','W'):
                return who
    return None


def _matrix8(state_or_board):
    """
    Extrai 8x8 do board. Prioriza 'tiles' conforme o kit.
    """
    board = getattr(state_or_board, "board", state_or_board)

    tiles = getattr(board, "tiles", None)
    if tiles is not None:
        try:
            if len(tiles) == 8 and all(isinstance(tiles[r], str) and len(tiles[r]) >= 8 for r in range(8)):
                return [[tiles[r][c] for c in range(8)] for r in range(8)]
        except Exception:
            pass

    for attr in ("grid", "board", "cells", "state", "matrix"):
        mat = getattr(board, attr, None)
        if mat is not None:
            try:
                if len(mat) == 8 and all(len(mat[r]) == 8 for r in range(8)):
                    return [[mat[r][c] for c in range(8)] for r in range(8)]
            except Exception:
                pass

    try:
        _ = board[0][0]
        return [[board[r][c] for c in range(8)] for r in range(8)]
    except Exception:
        pass

    txt = None
    to_str = getattr(board, "to_string", None)
    if callable(to_str):
        try:
            txt = to_str()
        except Exception:
            txt = None
    if txt is None:
        txt = str(board)
    lines = [ln.rstrip("\n") for ln in txt.splitlines() if ln.strip() != ""]
    lines = [ln[:8] for ln in lines if len(ln) >= 8]
    if len(lines) >= 8:
        lines = lines[-8:]
        return [[lines[r][c] for c in range(8)] for r in range(8)]

    raise RuntimeError("Não foi possível extrair a matriz 8x8 do board.")

# ---------- avaliação e agente ----------

def evaluate_mask(state, me):
    """
    Soma da máscara das minhas peças menos a do oponente, para 'me'.
    Convenção do kit: r=0 é a 1ª linha (topo), c=0 é a 1ª coluna (esquerda).
    """
    m = _matrix8(state)
    sm = so = 0
    for r in range(8):
        for c in range(8):
            who = _cell_owner(m[r][c])
            val = EVAL_TEMPLATE[r][c]
            if who == me:
                sm += val
            elif who in ('B','W') and who != me:
                so += val
    return float(sm - so)

def make_move(state):
    return minimax_move(state, depth=DEPTH, eval_fn=evaluate_mask, time_limit=4.5)
