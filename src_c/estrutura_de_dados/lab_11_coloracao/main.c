#include "caminhamentos.h"
#include <string.h>
#include <locale.h>
#define TAM 6

int main()
{
  int v_ant = 0;
    int matrizDFS[TAM][TAM]=
    {
        {0,1,0,0,0,1},
        {1,0,1,1,0,0},
        {0,1,0,1,1,0},
        {0,1,1,0,1,1},
        {0,0,1,1,0,1},
        {1,0,0,1,1,0},
    };
    int visitadoDFS[]= {0,0,0,0,0,0};

    printf("\n  DFS \n");
    DFS(matrizDFS, 3, visitadoDFS, v_ant);

    int matrizBFS[TAM][TAM]=
    {
        {0,1,0,0,0,1},
        {1,0,1,1,0,0},
        {0,1,0,1,1,0},
        {0,1,1,0,1,1},
        {0,0,1,1,0,1},
        {1,0,0,1,1,0},
    };
    int visitadoBFS[]= {0,0,0,0,0,0,0};

    printf("\n\n  BFS \n");
    BFS(matrizBFS, 3, visitadoBFS);


}
