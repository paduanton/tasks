#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include "produto.h"

int main()
{
    TipoPtNo *Lista;
    Produto dados;
    char operacao = ' ';

    Lista=Inicializa_Lista();


    do {
        system("cls");
        printf("Sistema de Cadastro de Produtos\n\n");
        printf("i - Inserir\n");
        printf("p - Imprimir\n");
        printf("s - Sair do Sistema\n");

        fflush(stdin);
        operacao = getchar();

        switch(tolower(operacao))
        {
        case 'i':
            ler_produtos(&dados);
            Lista=Insere_Produto(Lista, dados);
            break;

        case 'p':
            imprimir_produtos(Lista);
            system("pause");
            break;
        }
    } while(operacao != tolower('s'));

    return 0;
}
