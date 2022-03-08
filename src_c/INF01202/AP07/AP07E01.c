#include <stdio.h>
#include <stdlib.h>

#define NUMERO_MAXIMO_ALEATORIO 20
#define LINHA 6
#define COLUNA 4

int main()
{

	int i, j, produtoMatriz[COLUNA] = {1, 1, 1, 1}, matriz[LINHA][COLUNA], valorAuxiliar, maiorNumero = 0, maiorNumeroLinha, maiorNumeroColuna;

	srand(time(NULL));

	printf("Matriz\n");
	// preenche a matriz
	for (i = 0; i < LINHA; i++)
	{
		for (j = 0; j < COLUNA; j++)
		{
			matriz[i][j] = 0 + rand() % (NUMERO_MAXIMO_ALEATORIO + 1);
		}
	}

	// imprime a matriz
	for (i = 0; i < LINHA; i++)
	{
		for (j = 0; j < COLUNA; j++)
		{
			printf("%5d", matriz[i][j]);
		}
		printf("\n");
	}

	// troca 4 elementos da primeira linha pelos primeiros 4 da primeiracoluna
	for (i = 1; i < COLUNA; i++)
	{
		valorAuxiliar = matriz[0][i];
		matriz[0][i] = matriz[i][0];
		matriz[i][0] = valorAuxiliar;
	}

	printf("\n");
	printf("\n");

	printf("Matriz atualizada\n");

	// imprime a matriz novamente
	for (i = 0; i < LINHA; i++)
	{
		for (j = 0; j < COLUNA; j++)
		{
			printf("%5d", matriz[i][j]);
		}
		printf("\n");
	}

	// verificar a linha e coluna do maior elemento
	for (i = 0; i < COLUNA; i++)
	{
		for (j = 0; j < COLUNA; j++)
		{

			if (matriz[i][j] > maiorNumero)
			{
				maiorNumero = matriz[i][j];

				maiorNumeroLinha = i + 1;
				maiorNumeroColuna = j + 1;
			}
		}
	}

	printf("\n");
	printf("\n");

	printf("\nMaior valor da matriz: %d:", maiorNumero);
	printf("\nLinha do maior valor da matriz: %d:", maiorNumeroLinha);
	printf("\nColuna do valor da matriz: %d:", maiorNumeroColuna);

	// preenche a matriz dos produtos de cada linha
	for (i = 0; i < LINHA; i++)
	{
		for (j = 0; j < COLUNA; j++)
		{
			produtoMatriz[j] = produtoMatriz[j] * matriz[i][j];
		}
	}

	printf("\n");
	printf("\n");

	printf("Produtos de cada linha\n");
	for (i = 0; i < COLUNA; i++)
	{
		printf("%d\n", produtoMatriz[i]);
	}
	return 0;
}
