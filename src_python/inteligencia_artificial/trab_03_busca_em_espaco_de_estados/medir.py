# medir.py
import time
import importlib

# importa seu solucao.py
solucao = importlib.import_module("solucao")

START = "2_3541687"

def reconstrui(n):
    path = []
    while n.pai is not None:
        path.append(n.acao)
        n = n.pai
    path.reverse()
    return path

def mede_bfs():
    from collections import deque
    t0 = time.perf_counter()
    if START == solucao.OBJETIVO:
        return 0, 0.0, 0
    raiz = solucao.Nodo(START, None, None, 0)
    Q = deque([raiz])
    visit = {START}
    exp = 0
    while Q:
        n = Q.popleft()
        exp += 1
        for acao, est2 in solucao.sucessor(n.estado):
            if est2 in visit:
                continue
            filho = solucao.Nodo(est2, n, acao, n.custo + 1)
            if est2 == solucao.OBJETIVO:
                dt = time.perf_counter() - t0
                return exp, dt, len(reconstrui(filho))
            visit.add(est2)
            Q.append(filho)
    dt = time.perf_counter() - t0
    return exp, dt, None

def mede_dfs(limite_passos=1_000_000):
    t0 = time.perf_counter()
    if START == solucao.OBJETIVO:
        return 0, 0.0, 0
    raiz = solucao.Nodo(START, None, None, 0)
    S = [raiz]
    visit = {START}
    exp, passos = 0, 0
    while S:
        passos += 1
        if passos > limite_passos:
            break
        n = S.pop()
        exp += 1
        for acao, est2 in solucao.sucessor(n.estado):
            if est2 in visit:
                continue
            filho = solucao.Nodo(est2, n, acao, n.custo + 1)
            if est2 == solucao.OBJETIVO:
                dt = time.perf_counter() - t0
                return exp, dt, len(reconstrui(filho))
            visit.add(est2)
            S.append(filho)
    dt = time.perf_counter() - t0
    return exp, dt, None  # pode não encontrar em tempo hábil

def mede_astar(h):
    import heapq
    t0 = time.perf_counter()
    if START == solucao.OBJETIVO:
        return 0, 0.0, 0
    best_g = {START: 0}
    raiz = solucao.Nodo(START, None, None, 0)
    pq = []
    tie = 0
    heapq.heappush(pq, (h(START), tie, raiz)); tie += 1
    exp = 0
    while pq:
        _, _, n = heapq.heappop(pq)
        exp += 1
        if n.estado == solucao.OBJETIVO:
            dt = time.perf_counter() - t0
            return exp, dt, len(reconstrui(n))
        g = n.custo
        for acao, est2 in solucao.sucessor(n.estado):
            g2 = g + 1
            if g2 < best_g.get(est2, 10**9):
                best_g[est2] = g2
                filho = solucao.Nodo(est2, n, acao, g2)
                f2 = g2 + h(est2)
                heapq.heappush(pq, (f2, tie, filho)); tie += 1
    dt = time.perf_counter() - t0
    return exp, dt, None

def h_hamming(s): return solucao._hamming(s)
def h_manhattan(s): return solucao._manhattan(s)
def h_linear(s): return solucao._manhattan(s) + solucao._linear_conflicts(s)

def main():
    medidas = {
        "BFS": mede_bfs(),
        "DFS": mede_dfs(),
        "A* Hamming": mede_astar(h_hamming),
        "A* Manhattan": mede_astar(h_manhattan),
        "A* Manhattan + LinearConf": mede_astar(h_linear),
    }
    print("\nResultados para estado inicial:", START)
    print("Algoritmo; Expandidos; Tempo(s); Custo")
    for nome, (exp, t, custo) in medidas.items():
        print(f"{nome}; {exp}; {t:.6f}; {('None' if custo is None else custo)}")

if __name__ == "__main__":
    main()
