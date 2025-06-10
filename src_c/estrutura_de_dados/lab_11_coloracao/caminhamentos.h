#include <stdio.h>
#include <stdlib.h>
#include "fila.h"

#define TAM 6

void DFS(int grafo[][TAM], int v, int *visitado, int v_ant);
void BFS (int grafo[][TAM], int v,   int *visitado);
void colorir (int v, int vetor[], int cor, int v_ant);
