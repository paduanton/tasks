#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include "abp.h"

void imprimirArvore(pNodoA *a, int contadorAuxiliar){
    int i;

    if (a!= NULL){
        for(i=0;i<contadorAuxiliar;i++) {
            printf("=");
        }
        printf("%d\n",a->info);

        imprimirArvore(a->esquerda, contadorAuxiliar+1);
        imprimirArvore(a->direita, contadorAuxiliar+1);
    }
}

pNodoA* inserirArvore(pNodoA *a, int ch){
    if (a == NULL){
        a = (pNodoA*) malloc(sizeof(pNodoA));
        a->info = ch;
        a->esquerda = NULL;
        a->direita = NULL;
    } else if (ch < a->info) {
        a->esquerda = inserirArvore(a->esquerda,ch);
    } else {
        a->direita = inserirArvore(a->direita,ch);
    }

    return a;
}

void imprimirCaminhamentoPreFixado(pNodoA *a){
    if (a!= NULL){
        printf("%d\n",a->info);
        imprimirCaminhamentoPreFixado(a->esquerda);
        imprimirCaminhamentoPreFixado(a->direita);
    }
}

int contarNodos (pNodoA *a){
    if(!a) {
        return 0;
    }
    return 1 + contarNodos(a->esquerda) + contarNodos(a->direita);
}
