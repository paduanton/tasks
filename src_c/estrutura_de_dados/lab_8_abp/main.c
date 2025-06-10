#include <stdio.h>
#include <stdlib.h>
#include "abp.h"

int main()
{
    pNodoA *arvore = NULL;

    int contadorAuxiliar=1;

    printf("Caminhamento Pre Fixado\n\n");

    arvore= inserirArvore(arvore, 8);
    arvore= inserirArvore(arvore, 4);
    arvore= inserirArvore(arvore, 9);
    arvore= inserirArvore(arvore, 2);
    arvore= inserirArvore(arvore, 6);
    arvore= inserirArvore(arvore, 1);

    imprimirCaminhamentoPreFixado(arvore);

    printf("\nTotal de Nodos: %d\n\n",contarNodos(arvore));

    printf("Arvore\n\n");

    imprimirArvore(arvore, contadorAuxiliar);

    return 0;
}
