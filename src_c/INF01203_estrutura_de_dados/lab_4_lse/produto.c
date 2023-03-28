#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include "produto.h"


TipoPtNo* Inicializa_Lista()
{
    return NULL;
}

TipoPtNo* Insere_Produto(TipoPtNo* lista, Produto dados)
{
    TipoPtNo *anterior = NULL;
    TipoPtNo *lista_auxiliar = lista;
    TipoPtNo *novo;

    novo = (TipoPtNo*) malloc(sizeof(TipoPtNo));
    novo->info = dados;

    while(lista_auxiliar != NULL && (lista_auxiliar->info.codigo < novo->info.codigo))
    {
        anterior = lista_auxiliar;
        lista_auxiliar = lista_auxiliar->prox;
    }

    if(!anterior)
    {
        novo->prox = lista;
        lista = novo;
    }
    else
    {
        novo->prox = lista_auxiliar;
        anterior->prox = novo;
    }

    return lista;
}


void imprimir_produtos(TipoPtNo* lista)
{
    TipoPtNo* lista_auxiliar;

    if(!lista)
    {
        puts("lista esta vazia");
    }
    else
    {
        for(lista_auxiliar=lista; lista_auxiliar!=NULL; lista_auxiliar=lista_auxiliar->prox)
        {
            printf("Codigo: %d  Nome: %s  Preco: %d\n",
                   lista_auxiliar->info.codigo, lista_auxiliar->info.nome, lista_auxiliar->info.preco);
        }
    }
}

void ler_produtos(Produto *dados)
{
    fflush(stdin);
    printf("codigo: ");
    scanf("%d", &dados->codigo);

    fflush(stdin);
    printf("nome: ");
    gets(dados->nome);

    printf("preco: ");
    scanf("%d", &dados->preco);
    fflush(stdin);
}
