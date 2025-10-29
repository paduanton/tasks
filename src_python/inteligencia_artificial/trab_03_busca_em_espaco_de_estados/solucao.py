from __future__ import annotations
from dataclasses import dataclass
from typing import Iterable, Set, Tuple, Optional, List, Dict
import heapq
from collections import deque

OBJETIVO = "12345678_"
LADO = 3

@dataclass(frozen=True)
class Nodo:
    estado: str
    pai: Optional["Nodo"]
    acao: Optional[str]
    custo: int

    def __hash__(self) -> int:
        return hash(self.estado)

    def __eq__(self, other: object) -> bool:
        return isinstance(other, Nodo) and self.estado == other.estado

def _troca(s: str, i: int, j: int) -> str:
    if i == j:
        return s
    a, b = sorted((i, j))
    return s[:a] + s[b] + s[a+1:b] + s[a] + s[b+1:]


def sucessor(estado: str) -> Set[Tuple[str, str]]:
    res: Set[Tuple[str, str]] = set()
    idx = estado.index('_')
    r, c = divmod(idx, LADO)

    movimentos = [
        ("acima",   (-1, 0)),
        ("abaixo",  ( 1, 0)),
        ("esquerda",( 0,-1)),
        ("direita", ( 0, 1)),
    ]

    for acao, (dr, dc) in movimentos:
        nr, nc = r + dr, c + dc
        if 0 <= nr < LADO and 0 <= nc < LADO:
            j = nr * LADO + nc
            novo = _troca(estado, idx, j)
            res.add((acao, novo))
    return res

def expande(nodo: Nodo) -> Set[Nodo]:
    filhos: Set[Nodo] = set()
    for acao, est in sucessor(nodo.estado):
        filhos.add(Nodo(est, nodo, acao, nodo.custo + 1))
    return filhos

def _reconstrui_caminho(n: Nodo) -> List[str]:
    acoes: List[str] = []
    while n.pai is not None:
        acoes.append(n.acao)
        n = n.pai
    acoes.reverse()
    return acoes


def _astar(estado: str, hfun) -> Optional[List[str]]:
    if estado == OBJETIVO:
        return []

    best_g: Dict[str, int] = {estado: 0}
    start = Nodo(estado, None, None, 0)

    pq: List[Tuple[int, int, Nodo]] = []
    tie = 0
    heapq.heappush(pq, (hfun(estado), tie, start)); tie += 1

    while pq:
        _, _, atual = heapq.heappop(pq)
        g = atual.custo
        if atual.estado == OBJETIVO:
            return _reconstrui_caminho(atual)

        for acao, est2 in sucessor(atual.estado):
            g2 = g + 1
            if g2 < best_g.get(est2, 1 << 30):
                best_g[est2] = g2
                n2 = Nodo(est2, atual, acao, g2)
                f2 = g2 + hfun(est2)
                heapq.heappush(pq, (f2, tie, n2)); tie += 1
    return None

def _hamming(s: str) -> int:
    return sum(1 for i, ch in enumerate(s) if ch != '_' and ch != OBJETIVO[i])

OBJ_POS = {str(v): ((v-1)//LADO, (v-1)%LADO) for v in range(1, 9)}

def _manhattan(s: str) -> int:
    soma = 0
    for i, ch in enumerate(s):
        if ch == '_' or ch == OBJETIVO[i]:
            continue
        r, c = divmod(i, LADO)
        gr, gc = OBJ_POS[ch]
        soma += abs(r - gr) + abs(c - gc)
    return soma


def _linear_conflicts(s: str) -> int:
    penalty = 0
    for r in range(LADO):
        linha = s[r*LADO:(r+1)*LADO]
        pos = []
        for c, ch in enumerate(linha):
            if ch != '_' and OBJ_POS[ch][0] == r:
                pos.append((c, OBJ_POS[ch][1]))
        for i in range(len(pos)):
            for j in range(i+1, len(pos)):
                if pos[i][1] > pos[j][1]:
                    penalty += 2
    for c in range(LADO):
        col = [s[r*LADO + c] for r in range(LADO)]
        pos = []
        for r, ch in enumerate(col):
            if ch != '_' and OBJ_POS[ch][1] == c:
                pos.append((r, OBJ_POS[ch][0]))
        for i in range(len(pos)):
            for j in range(i+1, len(pos)):
                if pos[i][1] > pos[j][1]:
                    penalty += 2
    return penalty

def astar_hamming(estado: str) -> List[str]:
    return _astar(estado, _hamming)

def astar_manhattan(estado: str) -> List[str]:
    return _astar(estado, _manhattan)

def bfs(estado: str) -> Optional[List[str]]:
    if estado == OBJETIVO:
        return []
    raiz = Nodo(estado, None, None, 0)
    fila = deque([raiz])
    visitados = {estado}
    while fila:
        n = fila.popleft()
        for acao, est2 in sucessor(n.estado):
            if est2 in visitados:
                continue
            filho = Nodo(est2, n, acao, n.custo + 1)
            if est2 == OBJETIVO:
                return _reconstrui_caminho(filho)
            visitados.add(est2)
            fila.append(filho)
    return None


def dfs(estado: str) -> Optional[List[str]]:
    if estado == OBJETIVO:
        return []
    raiz = Nodo(estado, None, None, 0)
    pilha = [raiz]
    visitados = {estado}
    while pilha:
        n = pilha.pop()
        for acao, est2 in sucessor(n.estado):
            if est2 in visitados:
                continue
            filho = Nodo(est2, n, acao, n.custo + 1)
            if est2 == OBJETIVO:
                return _reconstrui_caminho(filho)
            visitados.add(est2)
            pilha.append(filho)
    return None


def astar_new_heuristic(estado: str) -> List[str]:
    def h(s: str) -> int:
        return _manhattan(s) + _linear_conflicts(s)
    return _astar(estado, h)
