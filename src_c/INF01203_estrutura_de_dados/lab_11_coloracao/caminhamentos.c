#include <stdio.h>
#include <stdlib.h>
#include "caminhamentos.h"

void colorir (int inicio, int visitado[],int cor, int v_ant)
{
    int i;

    if(visitado[v_ant] != cor)
    {
        visitado[inicio]=cor;
    }
    else
    {
        colorir(inicio, visitado, cor+1,v_ant);
    }
    v_ant=inicio+1;
}

void DFS(int grafo[][TAM], int inicio, int *visitado, int v_ant)
{
    int auxiliar, cor=1;

    colorir(inicio, visitado, cor, v_ant);

    printf("%d cor: %d\n", inicio+1, visitado[inicio]);

    visitado[inicio]=1;

    for(auxiliar=0; auxiliar < TAM; auxiliar++)
        if(grafo[inicio][auxiliar]==1 && visitado[auxiliar]==0)
        {
            DFS(grafo, auxiliar, visitado, v_ant);
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


