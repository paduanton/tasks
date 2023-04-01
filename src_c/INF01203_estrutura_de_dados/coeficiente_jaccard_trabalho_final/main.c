#include <time.h>
#include <stdlib.h>
#include <stdio.h>
#include <limits.h>
#include <string.h>
#include <assert.h>
#include <locale.h>
#include "jaccard.h"
#define TAM 100

float palavrasTexto1 = 0;
float palavrasTexto2 = 0;
float palavrasTexto1e2 = 0;

/*conta as palavras distintas na primeira arvore, arquivo*/
void contaPalavras1(noh *nohRaiz)
{

	if (nohRaiz != NULL)
	{
		palavrasTexto1 += 1;
		contaPalavras1(nohRaiz->esq);
		contaPalavras1(nohRaiz->dir);
	}
}

/*conta as palavras distintas na segunda arvore, arquivo*/
void contaPalavras2(noh *nohRaiz)
{

	if (nohRaiz != NULL)
	{
		palavrasTexto2 += 1;
		contaPalavras2(nohRaiz->esq);
		contaPalavras2(nohRaiz->dir);
	}
}

/*conta as palavras presentes nas duas arvores*/
void contaPalavras1e2(noh *nohRaiz1, noh *nohRaiz2)
{
	if (nohRaiz1 != NULL)
	{
		if (buscar(nohRaiz2, nohRaiz1->palavra) == 1)
		{
			palavrasTexto1e2 += 1;
		}
		contaPalavras1e2(nohRaiz1->esq, nohRaiz2);
		contaPalavras1e2(nohRaiz1->dir, nohRaiz2);
	}
}

main(int argc, char *argv[])
{
	setlocale(LC_ALL, "Portuguese");
	double tempo = 0.0;

	clock_t inicio = clock();

	FILE *fp;
	char nome[TAM], arquivo1[TAM], arquivo2[TAM], arquivo3[TAM];
	char c;
	int n = 0;
	arvore *raiz1;
	arvore *raiz2;
	arvore *stop;
	float jaccard;

	raiz1 = iniciaArvore();
	raiz2 = iniciaArvore();
	stop = iniciaArvore();
	if (argc > 3)
	{
		strcpy(arquivo1, argv[1]);
		strcpy(arquivo2, argv[2]);
		strcpy(arquivo3, argv[3]);
	}
	else
	{
		// descomentar para teste
		/*
		strcpy(arquivo1, "textoB.txt");
		strcpy(arquivo2, "textoE.txt");
		strcpy(arquivo3, "stopwords.txt");		*/
		printf("Este programa necessita de parâmetros para sua execução!\n\n");
	}
	if ((fp = fopen(arquivo3, "r")) != NULL)
	{
		while (fscanf(fp, "%s", nome) != -1)
		{
			inserir(stop, nome);
		}
		fclose(fp);
	}
	if ((fp = fopen(arquivo1, "r")) != NULL)
	{
		while (fscanf(fp, "%s", nome) != -1)
		{
			if (limpaNome(nome) == 1)
			{
				if (buscar(stop->raiz, nome) == 0)
				{
					inserir(raiz1, nome);
				}
			}
		}
		fclose(fp);
	}
	if ((fp = fopen(arquivo2, "r")) != NULL)
	{
		while (fscanf(fp, "%s", nome) != -1)
		{
			if (limpaNome(nome) == 1)
			{
				if (buscar(stop->raiz, nome) == 0)
				{
					inserir(raiz2, nome);
				}
			}
		}

		fclose(fp);
	}
	contaPalavras1(raiz1->raiz);
	contaPalavras1e2(raiz1->raiz, raiz2->raiz);
	contaPalavras2(raiz2->raiz);

	// Descomentar para listar a arvore
	// listar(raiz1->raiz);
	// listar(raiz2->raiz);

	if (palavrasTexto1 > 0 && palavrasTexto2 > 0)
	{
		jaccard = palavrasTexto1e2 / ((palavrasTexto1 + palavrasTexto2) - palavrasTexto1e2);

		printf("Palavras distintas arquivo \"%s\" = %f\n\n", arquivo1, palavrasTexto1);
		printf("Palavras distintas arquivo \"%s\" = %f\n\n", arquivo2, palavrasTexto2);
		printf("Palavras presentes nos 2 arquivos = %f\n\n", palavrasTexto1e2);

		printf("Jaccard = %.2f\n\n", jaccard);
	}
	clock_t fim = clock();
	tempo += (double)(fim - inicio) / CLOCKS_PER_SEC;

	printf("Tempo gasto %f segundos.\n\n", tempo);
	system("pause");
}
