#include <time.h>
#include <stdlib.h>
#include <stdio.h>
#include <limits.h>
#include <string.h>
#include <assert.h>
#include <locale.h>
#define TAM 100

struct noh
{
	struct noh * esq;
	struct noh * dir;
	char palavra[TAM];
	int qtd;
};

struct arvore
{
	struct noh * raiz;
};
typedef struct arvore arvore;
typedef struct noh noh;

void leArquivo2(FILE *file);
int limpaNome(char *nome);
void replace(char *palavra, char caracter);
void leArquivo(FILE *file, arvore * raiz);
void listar ( noh * nohRaiz );
int buscar ( noh * nohRaiz, char palavra[TAM]);
arvore * iniciaArvore();
void inserir ( arvore * raiz, char palavra [TAM] );
void balancearArvore ( arvore * const raiz );
int max(int x, int y);
noh * balancearNoh ( noh * const nohRaiz );
int fatorBalanceamento ( const noh * const nohRaiz );
noh * rotacionar_dir_dir ( noh * const nohRaiz );
noh * rotacionar_dir_esq ( noh * const nohRaiz );
noh * rotationar_esq_dir (noh * const nohRaiz );
noh * rotacionar_esq_esq ( noh * const nohRaiz );
int altura ( const noh * const nohRaiz );
int limpaNome(char *nome);
noh * iniciaNoh ( char palavra[TAM] );
