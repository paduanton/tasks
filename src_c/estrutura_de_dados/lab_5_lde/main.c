#include <stdlib.h>
#include <stdio.h>
#include "lde.h"

int main()
{
    Nodo *lista;
    Produto produto;

    int codigo;
    char operacao = ' ';

    lista = inicializar();

    while(operacao!=tolower('s'))
    {
        system("cls");
        printf("p - Imprimir\n");
        printf("v - Imprimir Reverso\n");
        printf("i - Inserir Ordenado\n");
        printf("r - Remover\n");
        printf("s - Encerrar o Programa\n");

        fflush(stdin);

        operacao=getchar();

        switch(tolower(operacao))
        {
        case 'i':
            ler_produto(&produto);
            lista=inserir_ordenado(lista, produto);

            break;
        case 'p':
            imprimir(lista);
            system("pause");
            break;

        case 'v':
            imprimir_reverso(lista);
            system("pause");
            break;

        case 'r':
            printf("qual o codigo do produto a ser removido? ");
            fflush(stdin);

            scanf("%d", &codigo);
            lista=remover(lista, codigo);

            break;
        case 's':
            lista = destruir(lista);

            imprimir(lista);

            return 0;
        }
    }
}
