#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include "lde.h"


Nodo* inicializar(void)
{
    return NULL;
}

void imprimir(Nodo* lista)
{
    Nodo* nodo_auxiliar=lista;
    if (lista == NULL)
    {
        puts("lista vazia");

    }
    else
    {
        do
        {
            printf("codigo = %d nome = %s preco = %f\n",
                   nodo_auxiliar->produto.codigo,
                   nodo_auxiliar->produto.nome,
                   nodo_auxiliar->produto.preco);
            nodo_auxiliar = nodo_auxiliar->proximo;
        }
        while (nodo_auxiliar != NULL);
    }
}

void imprimir_reverso(Nodo *lista)
{
    Nodo *nodo_auxiliar;
    if (lista==NULL)
    {
        printf("lista vazia");
    }
    else
    {
        nodo_auxiliar=lista;

        while (nodo_auxiliar->proximo!=NULL)
        {
            nodo_auxiliar=nodo_auxiliar->proximo;
        }
        while (nodo_auxiliar!=NULL)
        {
            printf("codigo = %d nome = %s preco = %f\n",
                   nodo_auxiliar->produto.codigo,
                   nodo_auxiliar->produto.nome,
                   nodo_auxiliar->produto.preco);
            nodo_auxiliar= nodo_auxiliar->anterior;
        }
    }
}

Nodo* inserir_ordenado(Nodo *lista, Produto produto)
{
    Nodo *novo, *nodo_auxiliar;
    novo = (Nodo*) malloc(sizeof(Nodo));

    novo->produto = produto;

    if(!lista)
    {
        novo->proximo = NULL;
        novo->anterior = NULL;
        lista = novo;
    }
    else if(novo->produto.codigo < lista->produto.codigo)
    {
        novo->proximo = lista;
        lista->anterior = novo;
        lista = novo;
    }
    else
    {

        nodo_auxiliar = lista;

        while (nodo_auxiliar->proximo && novo->produto.codigo > nodo_auxiliar->produto.codigo)
        {
            nodo_auxiliar=nodo_auxiliar->proximo;
        }

        novo->proximo = nodo_auxiliar->proximo;

        if(nodo_auxiliar->proximo)
        {
            nodo_auxiliar->proximo->anterior = novo;
        }

        novo->anterior = nodo_auxiliar;
        nodo_auxiliar->proximo = novo;
    }

    return lista;
}

Nodo* inserir_inicio(Nodo *lista, Produto produto)
{
    Nodo *novo;
    novo = (Nodo*) malloc(sizeof(Nodo));

    novo->produto = produto;
    novo->anterior = NULL;
    novo->proximo = lista;

    if (lista != NULL)
    {
        lista->anterior = novo;
    }

    lista = novo;

    return lista;
}

Nodo* inserir_final(Nodo *lista, Produto produto)
{
    Nodo *novo, *nodo_auxiliar;

    novo = (Nodo*) malloc(sizeof(Nodo));

    novo->produto = produto;
    novo->proximo = NULL;

    if ((lista) == NULL)
    {
        lista = novo;
        novo->anterior = NULL;
    }
    else
    {
        nodo_auxiliar = lista;
        while (nodo_auxiliar->proximo != NULL)
            nodo_auxiliar=nodo_auxiliar->proximo;
        nodo_auxiliar->proximo = novo;
        novo->anterior = nodo_auxiliar;
    }

    return lista;
}

Nodo* destruir(Nodo* lista)
{
    Nodo *nodo_auxiliar;

    while (lista != NULL)
    {
        nodo_auxiliar = lista;
        lista = lista->proximo;
        free(nodo_auxiliar);
    }
    free(lista);
    return NULL;
}

void ler_produto(Produto *produto)
{
    fflush(stdin);
    printf("codigo: ");
    scanf("%d", &produto->codigo);

    fflush(stdin);
    printf("nome: ");
    gets(produto->nome);

    printf("preco: ");
    scanf("%f", &produto->preco);
    fflush(stdin);
}

Nodo* remover(Nodo *lista, int codigo)
{
    Nodo* nodo_auxiliar;
    nodo_auxiliar = lista;

    while(nodo_auxiliar)
    {
        if(nodo_auxiliar->produto.codigo == codigo)
        {
            nodo_auxiliar->proximo->anterior = nodo_auxiliar->anterior;

            if(nodo_auxiliar->anterior)
            {
                nodo_auxiliar->anterior->proximo = nodo_auxiliar->anterior;
            }
        }
    }
}
