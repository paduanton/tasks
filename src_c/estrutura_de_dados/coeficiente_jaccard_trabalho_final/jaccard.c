#include <time.h>
#include <stdlib.h>
#include <stdio.h>
#include <limits.h>
#include <string.h>
#include <assert.h>
#include <locale.h>
#include "jaccard.h"
#define TAM 100

/* Inícia novo nó na arvore, alocando a memória necessária.*/

noh *iniciaNoh(char palavra[TAM])
{
	noh *novoNoh;

	novoNoh = malloc(sizeof(noh));
	if (novoNoh == NULL)
	{
		puts("Sem memória para alocação\n");
		system("pause");
	}
	novoNoh->esq = NULL;
	novoNoh->dir = NULL;
	strcpy(novoNoh->palavra, palavra);
	novoNoh->qtd = 1;

	return novoNoh;
}
/* Limpa o texto, deixando apenas os caracteres permitidos */
int limpaNome(char *nome)
{
	int i, j, tag, size_str, retorno = 1;
	char letras[27] = "abcdefghijklmnopqrstuvwxyzç";
	tag = 0;
	size_str = strlen(nome);

	if (size_str > 1)
	{
		for (i = 0; i < size_str; i++)
		{
			for (j = 0; j < 27; j++)
			{
				nome[i] = tolower(nome[i]);
				if (nome[i] == letras[j])
				{
					tag = 1;
					break;
				}
			}
			if (tag == 0)
			{
				replace(nome, nome[i]);
				return limpaNome(nome);
				break;
			}
			else
			{
				tag = 0;
			}
		}
	}
	else
	{
		for (j = 0; j < 27; j++)
		{
			nome[0] = tolower(nome[0]);
			if (nome[0] == letras[j] || nome[j] == '\0')
			{
				tag = 1;
				break;
			}
		}
	}

	if (strlen(nome) == 1)
	{
		retorno = 0;
	}
	return retorno;
}
/*retorna a altura do nó na arvore*/
int altura(const noh *const nohRaiz)
{
	int altura_esq = 0;
	int altura_dir = 0;

	if (nohRaiz->esq)
		altura_esq = altura(nohRaiz->esq);

	if (nohRaiz->dir)
		altura_dir = altura(nohRaiz->dir);

	return max(altura_dir, altura_esq) + 1;
}

noh *rotacionar_esq_esq(noh *const nohRaiz)
{
	noh *temp_raiz = nohRaiz;
	noh *esq_raiz = temp_raiz->esq;

	temp_raiz->esq = esq_raiz->dir;
	esq_raiz->dir = temp_raiz;

	return esq_raiz;
}

noh *rotationar_esq_dir(noh *const nohRaiz)
{
	noh *temp_raiz = nohRaiz;
	noh *esq_raiz = temp_raiz->esq;
	noh *dir_raiz = esq_raiz->dir;

	temp_raiz->esq = dir_raiz->dir;
	esq_raiz->dir = dir_raiz->esq;
	dir_raiz->esq = esq_raiz;
	dir_raiz->dir = temp_raiz;

	return dir_raiz;
}

noh *rotacionar_dir_esq(noh *const nohRaiz)
{
	noh *temp_raiz = nohRaiz;
	noh *dir_raiz = temp_raiz->dir;
	noh *esq_raiz = dir_raiz->esq;

	temp_raiz->dir = esq_raiz->esq;
	dir_raiz->esq = esq_raiz->dir;
	esq_raiz->dir = dir_raiz;
	esq_raiz->esq = temp_raiz;

	return esq_raiz;
}
/*rotaciona o nó, segundo o fator de balanceamento*/
noh *rotacionar_dir_dir(noh *const nohRaiz)
{
	noh *temp_raiz = nohRaiz;
	noh *dir_raiz = temp_raiz->dir;

	temp_raiz->dir = dir_raiz->esq;
	dir_raiz->esq = temp_raiz;

	return dir_raiz;
}
int fatorBalanceamento(const noh *const nohRaiz)
{
	int fator = 0;

	if (nohRaiz->esq)
		fator += altura(nohRaiz->esq);

	if (nohRaiz->dir)
		fator -= altura(nohRaiz->dir);

	return fator;
}
noh *balancearNoh(noh *const nohRaiz)
{
	noh *nohBalanceado = NULL;

	if (nohRaiz->esq)
		nohRaiz->esq = balancearNoh(nohRaiz->esq);

	if (nohRaiz->dir)
		nohRaiz->dir = balancearNoh(nohRaiz->dir);

	int fator = fatorBalanceamento(nohRaiz);

	if (fator >= 2)
	{
		if (fatorBalanceamento(nohRaiz->esq) <= -1)
			nohBalanceado = rotationar_esq_dir(nohRaiz);
		else
			nohBalanceado = rotacionar_esq_esq(nohRaiz);
	}
	else if (fator <= -2)
	{
		if (fatorBalanceamento(nohRaiz->dir) >= 1)
			nohBalanceado = rotacionar_dir_esq(nohRaiz);
		else
			nohBalanceado = rotacionar_dir_dir(nohRaiz);
	}
	else
	{
		nohBalanceado = nohRaiz;
	}

	return nohBalanceado;
}
/*retorna o maior valor entre dois inteiros*/
int max(int x, int y)
{
	if (x > y)
	{
		return x;
	}
	return y;
}
/*realiza o balanceamento da arvore*/
void balancearArvore(arvore *const raiz)
{
	noh *nova_raiz = NULL;

	nova_raiz = balancearNoh(raiz->raiz);

	if (nova_raiz != raiz->raiz)
	{
		raiz->raiz = nova_raiz;
	}
}
/*insere uma nova palavra na arvore enviada por parametro*/
void inserir(arvore *raiz, char palavra[TAM])
{
	noh *novoNoh = NULL;
	noh *proximo = NULL;
	noh *anterior = NULL;

	if (raiz->raiz == NULL)
	{
		novoNoh = iniciaNoh(palavra);
		raiz->raiz = novoNoh;
	}
	else
	{
		proximo = raiz->raiz;

		while (proximo != NULL)
		{
			anterior = proximo;

			if (strcmp(palavra, proximo->palavra) < 0)
			{
				proximo = proximo->esq;
			}
			else if (strcmp(palavra, proximo->palavra) > 0)
			{
				proximo = proximo->dir;
			}
			else if (strcmp(palavra, proximo->palavra) == 0)
			{
				proximo->qtd++;
				return;
			}
		}

		novoNoh = iniciaNoh(palavra);

		if (strcmp(palavra, anterior->palavra) < 0)
			anterior->esq = novoNoh;

		if (strcmp(palavra, anterior->palavra) > 0)
			anterior->dir = novoNoh;
	}

	balancearArvore(raiz);
}
/*inicia a arvore */
arvore *iniciaArvore()
{
	arvore *tree = NULL;

	if ((tree = malloc(sizeof(arvore))) == NULL)
	{
		return NULL;
	}

	tree->raiz = NULL;

	return tree;
}
/*busca uma determinada palavra na árvore*/
int buscar(noh *nohRaiz, char palavra[TAM])
{
	if (nohRaiz == NULL)
	{
		return 0;
	}
	else
	{
		if (strcmp(palavra, nohRaiz->palavra) < 0)
		{
			return buscar(nohRaiz->esq, palavra);
		}
		else if (strcmp(palavra, nohRaiz->palavra) > 0)
		{
			return buscar(nohRaiz->dir, palavra);
		}
		else if (strcmp(palavra, nohRaiz->palavra) == 0)
		{
			return 1;
		}
	}
}
/*lista determinada arvore, partindo do nó raiz*/
void listar(noh *nohRaiz)
{
	if (nohRaiz != NULL)
	{
		printf("Palavra = %s, qtd = %d, altura = %d, FATBAL = %d\n", nohRaiz->palavra, nohRaiz->qtd, altura(nohRaiz), fatorBalanceamento(nohRaiz));
		listar(nohRaiz->esq);
		listar(nohRaiz->dir);
	}
}

/* Substitui determinado caracter na palavra passada por parametro*/
void replace(char *palavra, char caracter)
{
	int i, j, size_str;

	size_str = strlen(palavra);

	for (i = 0; i < size_str; i++)
	{
		if (palavra[i] == caracter)
		{
			for (j = i; j < size_str; j++)
			{
				palavra[j] = palavra[j + 1];
			}
			size_str--;
			i--;
		}
	}
}
