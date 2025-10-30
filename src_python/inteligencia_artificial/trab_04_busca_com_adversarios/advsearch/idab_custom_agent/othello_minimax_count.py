from .minimax import minimax_move

DEPTH = 5  # ajuste livre

# ---------- helpers comuns ----------

def _cell_owner(cell):
    """
    Normaliza a peça para 'B', 'W' ou None.
    Aceita int (1/-1), str ('B','W','.'), ou objetos com atributos usuais.
    """
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
    Extrai uma matriz 8x8 (lista de listas de chars) do board.
    Prioriza 'tiles' (conforme o kit), depois fallbacks.
    """
    board = getattr(state_or_board, "board", state_or_board)

    # 1) tiles (lista de strings 8x8)
    tiles = getattr(board, "tiles", None)
    if tiles is not None:
        try:
            if len(tiles) == 8 and all(isinstance(tiles[r], str) and len(tiles[r]) >= 8 for r in range(8)):
                return [[tiles[r][c] for c in range(8)] for r in range(8)]
        except Exception:
            pass

    # 2) outros atributos 2D
    for attr in ("grid", "board", "cells", "state", "matrix"):
        mat = getattr(board, attr, None)
        if mat is not None:
            try:
                if len(mat) == 8 and all(len(mat[r]) == 8 for r in range(8)):
                    return [[mat[r][c] for c in range(8)] for r in range(8)]
            except Exception:
                pass

    # 3) indexação dupla
    try:
        _ = board[0][0]
        return [[board[r][c] for c in range(8)] for r in range(8)]
    except Exception:
        pass

    # 4) parsing textual (último recurso)
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

def _counts(state):
    m = _matrix8(state)
    nb = nw = 0
    for r in range(8):
        for c in range(8):
            who = _cell_owner(m[r][c])
            if who == 'B': nb += 1
            elif who == 'W': nw += 1
    return nb, nw


def evaluate_count(state, me):
    """
    (#minhas - #oponente) para o jogador 'me'.
    """
    nb, nw = _counts(state)
    diff = nb - nw
    return float(diff if me == 'B' else -diff)


def make_move(state):
    return minimax_move(state, depth=DEPTH, eval_fn=evaluate_count, time_limit=4.5)
