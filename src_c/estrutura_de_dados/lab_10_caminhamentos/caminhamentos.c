#include <stdio.h>
#include <stdlib.h>
#include "caminhamentos.h"

void DFS(int grafo[][TAM], int inicio, int *visitado)
{
    int auxiliar;

    visitado[inicio]=1;

    printf("%d ", inicio+1);

    for(auxiliar=0; auxiliar < TAM+1; auxiliar++)
        if(grafo[inicio][auxiliar]==1 && visitado[auxiliar]==0) {
            DFS(grafo, auxiliar, visitado);
        }

}

void BFS (int grafo[][TAM], int inicio, int *visitado)
{
    int auxiliar;
    TipoFila *fila;

    fila = cria_fila();
    fila = insere(fila, inicio);

    visitado[inicio]= 1;

    while (!vazia(fila))
    {
        inicio = removeFila(&fila);
        printf("%d ",inicio+1);

        for(auxiliar = 0; auxiliar < TAM; auxiliar++)
            if ((grafo[inicio][auxiliar]== 1) && (visitado[auxiliar]==0))
            {
                fila = insere(fila,auxiliar);
                visitado[auxiliar]= 1;
            }
    }
}


