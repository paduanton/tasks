#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include "tad_avl.h"

int altura (NodoAVL *arvore)
{
    int altura_esquerda, altura_direita;
    if (arvore == NULL)
        return 0;
    else
    {
        altura_esquerda = altura (arvore->esquerda);
        altura_direita = altura (arvore->direita);
        if (altura_esquerda > altura_direita) {
            return (1 + altura_esquerda);
        } else {
            return (1 + altura_direita);
        }
    }
}

int calcula_fator(NodoAVL *arvore)
{
    return abs(altura(arvore->esquerda) - altura(arvore->direita));
}

void calcula_maior_fator(NodoAVL *arvore, int *maior)
{
    int fator_auxiliar;

    if(arvore)
    {
        fator_auxiliar = calcula_fator(arvore);

        if(fator_auxiliar > *maior)
            *maior = fator_auxiliar;

        calcula_maior_fator(arvore->esquerda, maior);
        calcula_maior_fator(arvore->direita, maior);
    }
}

void imprimir_arvore (NodoAVL *arvore, int aux)
{
    int i;

    if (arvore)
    {
        for(i=0; i<aux; i++) {
            printf("=");
        }

        printf("%d\n",arvore->info);

        imprimir_arvore(arvore->esquerda, aux+1);
        imprimir_arvore(arvore->direita, aux+1);
    }
}

NodoAVL* inserir_arvore(NodoAVL *arvore, int info)
{
    if (!arvore)
    {
        arvore = (NodoAVL*) malloc(sizeof(NodoAVL));
        arvore->info = info;
        arvore->esquerda = NULL;
        arvore->direita = NULL;
    }
    else if (info < arvore->info) {
        arvore->esquerda = inserir_arvore(arvore->esquerda,info);
    } else {
        arvore->direita = inserir_arvore(arvore->direita,info);
    }

    return arvore;
}
