#!/usr/bin/env bash
set -euo pipefail

# Caminhos
ROOT_DIR="$(cd "$(dirname "$0")" && pwd)"
AGENT_DIR="$ROOT_DIR/advsearch/idab_custom_agent"

# 1) Testes básicos (se existirem no kit)
echo "[1/5] Executando testes..."
if [ -f "$ROOT_DIR/test_minimax_tttm.py" ]; then
  python "$ROOT_DIR/test_minimax_tttm.py"
fi
if [ -f "$ROOT_DIR/test_pruning.py" ]; then
  python "$ROOT_DIR/test_pruning.py"
fi
if [ -f "$ROOT_DIR/test_mcts.py" ]; then
  # opcional
  python "$ROOT_DIR/test_mcts.py" || true
fi

# 2) Partida demonstrativa – TTTM (Humano vs nosso minimax, pode pular se quiser)
echo "[2/5] Rodando TTTM demonstração (humano vs agente) – opcional"
python "$ROOT_DIR/server.py" tttm \
  "$ROOT_DIR/advsearch/humanplayer/agent.py" \
  "$AGENT_DIR/tttm_minimax.py" \
  -d 9 -l "$ROOT_DIR/history_tttm.txt" -o "$ROOT_DIR/results_tttm.xml" || true

# 3) Mini-torneio Othello (ida/volta) entre as três heurísticas
echo "[3/5] Mini-torneio Othello (ida e volta) - gerando resultados..."
RESULTS_TSV="$ROOT_DIR/mini_torneio_othello.tsv"
echo -e "match\tfirst_player\tsecond_player\tfinal_disc_score\twinner" > "$RESULTS_TSV"

run_match () {
  local first="$1"
  local second="$2"
  local label="$3"
  # O servidor imprime resumo ao final. Redirecionamos para capturar placar e vencedor.
  local LOG="$ROOT_DIR/${label}.log"
  python "$ROOT_DIR/server.py" othello "$first" "$second" -d 5 > "$LOG" 2>&1 || true
  # Extrair linhas finais úteis (ajuste se o servidor imprimir diferente no seu kit)
  local SCORE="$(grep -E 'Final score|Final Score|Score' "$LOG" | tail -n1 || true)"
  local WIN="$(grep -Ei 'winner|vencedor' "$LOG" | tail -n1 || true)"
  echo -e "${label}\t${first}\t${second}\t${SCORE}\t${WIN}" >> "$RESULTS_TSV"
  echo "=> ${label} : ${SCORE} | ${WIN}"
}

# Caminhos curtos
COUNT="$AGENT_DIR/othello_minimax_count.py"
MASK="$AGENT_DIR/othello_minimax_mask.py"
CUST="$AGENT_DIR/othello_minimax_custom.py"

# Ida e volta (cada um começa uma vez)
run_match "$COUNT" "$MASK" "count_vs_mask"
run_match "$MASK"  "$COUNT" "mask_vs_count"
run_match "$COUNT" "$CUST"  "count_vs_custom"
run_match "$CUST"  "$COUNT" "custom_vs_count"
run_match "$MASK"  "$CUST"  "mask_vs_custom"
run_match "$CUST"  "$MASK"  "custom_vs_mask"

# 4) Torneio: seu agente final (tournament_agent.py) vs randomplayer e vs humano (opcional)
echo "[4/5] Testando agent do torneio vs randomplayer..."
python "$ROOT_DIR/server.py" othello \
  "$AGENT_DIR/tournament_agent.py" \
  "$ROOT_DIR/advsearch/randomplayer/agent.py" -d 5 || true

# 5) Pacote final ZIP
echo "[5/5] Empacotando entrega (idab_custom_agent.zip)..."
cd "$ROOT_DIR/advsearch"
zip -r "$ROOT_DIR/idab_custom_agent.zip" "idab_custom_agent"

echo "Concluído. Entregáveis:"
echo " - $RESULTS_TSV     (mini torneio)"
echo " - $ROOT_DIR/idab_custom_agent.zip (pasta do agente)"
echo " - history_tttm.txt / results_tttm.xml (se gerados)"
