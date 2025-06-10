#include <stdio.h>
#include <stdlib.h>
#include "tad_pilha.h"


int main ()
{
    int i;
    Pilha *pilha1, *pilha2, *pilha3, *pilha4;

    pilha1 = InicializaPilha();
    pilha2 = InicializaPilha();
    pilha3 = InicializaPilha();
    pilha4 = InicializaPilha();

    // primeiro cenario de teste
    printf("PRIMEIRO CENARIO DE TESTE\n\n");

    for(i=1; i<5; i++) {
        pilha1=PushPilha(pilha1,i);
    }

    for(i=2; i<5; i++) {
        pilha2=PushPilha(pilha2,i);
    }

    ImprimirPilha(pilha1);
    printf("\n\n");
    ImprimirPilha(pilha2);


    printf("\n");

    if(compara(pilha1,pilha2))
    {
        printf("pilhas sao iguais!");
    }
    else
    {
        printf("pilhas sao diferentes!");
    }

    // segundo cenario de teste
    printf("\n\n\n\nSEGUNDO CENARIO DE TESTE\n\n");

    for(i=1; i<5; i++) {
        pilha3=PushPilha(pilha3,i);
    }

    for(i=1; i<5; i++) {
        pilha4=PushPilha(pilha4,i);
    }

    ImprimirPilha(pilha3);
    printf("\n\n");
    ImprimirPilha(pilha4);

    printf("\n");

    if(compara(pilha3,pilha4))
    {
        printf("pilhas sao iguais!");
    }
    else
    {
        printf("pilhas sao diferentes!");
    }

    printf("\n");

    return 0;
}
