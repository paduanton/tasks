#include "caminhamentos.h"
#include <string.h>
#include <locale.h>
#define TAM 8

int main()
{

    int matrizDFS[TAM][TAM]= {
        {0,1,1,0,0,0,0,0},
        {0,0,0,1,0,0,0,0},
        {0,0,0,1,1,0,0,0},
        {0,0,0,0,1,1,0,1},
        {0,0,0,0,0,0,0,0},
        {0,0,0,0,1,0,0,0},
        {0,1,0,0,0,0,0,0},
        {0,0,0,0,0,0,1,0}
    };
    int visitadoDFS[]={0,0,0,0,0,0,0,0,0};

    printf("\n  DFS \n");
    DFS(matrizDFS, 0, visitadoDFS);

    int matrizBFS[TAM][TAM]= {
        {0,1,1,0,0,0,0,0},
        {0,0,0,1,0,0,0,0},
        {0,0,0,1,1,0,0,0},
        {0,0,0,0,1,1,0,1},
        {0,0,0,0,0,0,0,0},
        {0,0,0,0,1,0,0,0},
        {0,1,0,0,0,0,0,0},
        {0,0,0,0,0,0,1,0}
    };
    int visitadoBFS[]={0,0,0,0,0,0,0,0,0};

    printf("\n\n  BFS \n");
    BFS(matrizBFS, 0, visitadoBFS);

}
