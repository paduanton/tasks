#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include "tad_avl.h"

int main()
{

    NodoAVL *arvore_a=NULL, *arvore_b=NULL;
    int i, auxiliar_a=1, auxiliar_b=1, fator_a = 0, fator_b = 0;

    /* CASO 1 */
    printf("CASO 1 (A)\n\n");

    arvore_a = inserir_arvore(arvore_a, 42);
    arvore_a = inserir_arvore(arvore_a, 15);
    arvore_a = inserir_arvore(arvore_a, 88);
    arvore_a = inserir_arvore(arvore_a, 6);
    arvore_a = inserir_arvore(arvore_a, 27);
    arvore_a = inserir_arvore(arvore_a, 63);
    arvore_a = inserir_arvore(arvore_a, 94);
    arvore_a = inserir_arvore(arvore_a, 20);
    arvore_a = inserir_arvore(arvore_a, 57);
    arvore_a = inserir_arvore(arvore_a, 71);

    imprimir_arvore(arvore_a, auxiliar_a);
    calcula_maior_fator(arvore_a, &fator_a);

    printf("\n\nFator Arvore (A): %d", fator_a);

    /* CASO 2 */
    printf("\n\nCASO 2 (B)\n\n");

    arvore_b = inserir_arvore(arvore_b, 42);
    arvore_b = inserir_arvore(arvore_b, 15);
    arvore_b = inserir_arvore(arvore_b, 27);
    arvore_b = inserir_arvore(arvore_b, 20);

    imprimir_arvore(arvore_b, auxiliar_b);
    calcula_maior_fator(arvore_b, &fator_b);

    printf("\n\nFator Arvore (B): %d\n\n", fator_b);

    return 0;
}
