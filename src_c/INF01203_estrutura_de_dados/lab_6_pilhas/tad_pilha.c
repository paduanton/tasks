#include <stdio.h>
#include <stdlib.h>
#include "tad_pilha.h"


struct TPtPilha
{
    Info dado;
    struct TPtPilha *elo;
};


Pilha* InicializaPilha (void)
{
    return NULL;
}

int PilhaVazia (Pilha *Topo)
{
    if (Topo==NULL)
        return 1;
    else
        return 0;
}

void ImprimirPilha (Pilha *Topo)
{
    Pilha *ptaux;

    if (Topo != NULL)
    {
        puts("---Imprimindo pilha---");
        for (ptaux=Topo; ptaux!=NULL; ptaux=ptaux->elo)
            printf("%d\n",ptaux->dado);
        puts("-------Fim pilha------");
    }
    else
        puts("Pilha vazia");

}


Pilha* PushPilha (Pilha *Topo, Info info)
{
    Pilha *novo; //novo elemento
    Pilha *ptaux = Topo; //ponteiro auxiliar para percorrer a lista

    /*aloca um novo nodo */
    novo = (Pilha*) malloc(sizeof(Pilha));
    novo->elo = NULL;

    /*insere a informação no novo nodo*/
    novo->dado = info;

    /*encaeia o elemento*/
    novo->elo = Topo;
    Topo = novo;
    return Topo;
}


int PopPilha (Pilha **Topo, Info *info) //retorna 1 se exclui e zero se não exclui
{
    Pilha* ptaux;

    if (PilhaVazia(*Topo))
        return 0;   //não tem nada na pilha
    else
    {
        *info = (*Topo)->dado;     // devolve o valor do topo
        ptaux = *Topo;          //guarda o endereço do topo
        *Topo = (*Topo)->elo;     //o próximo passa a ser o topo
        free(ptaux);           //libera o que estava no topo
        ptaux=NULL;
        return 1;
    }
}

Info ConsultaPilha (Pilha *Topo)
{
    if (Topo==NULL)
        return 0;
    else
        return Topo->dado;

}

Pilha* DestroiPilha (Pilha *Topo)
{
    Pilha *ptaux;
    while (Topo != NULL)
    {
        ptaux = Topo;          //guarda o endereço do topo
        Topo = Topo->elo;     //o próximo passa a ser o topo
        free(ptaux);           //libera o que estava no topo
    }
    return NULL;
}

int compara(Pilha *pilha1, Pilha *pilha2)
{
    Info info1, info2;

    while(!PilhaVazia(pilha1) && !PilhaVazia(pilha2))
    {
        PopPilha(&pilha1, &info1);
        PopPilha(&pilha2, &info2);

        if(info1 != info2) {
            return 0;
        }
    }

    if(PilhaVazia(pilha1) && PilhaVazia(pilha2)) {
        return 1;
    }

    return 0;
}

