#include <stdio.h>
#include <string.h>

#define MAX_COMPRIMENTO 20
#define MIN_COMPRIMENTO 2

int main()
{
	int quantidadeNumeros, i;
	double somaNumeros = 0, mediaNumeros, numeros[MAX_COMPRIMENTO - MIN_COMPRIMENTO + 1];

	printf("Informe quantos numeros deseja inserir: ");
	scanf("%d", &quantidadeNumeros);

	for (i = 0; i < quantidadeNumeros; i++)
	{
		printf("Digite o numero #%d: ", i + 1);

		scanf("%lf", &numeros[i]);
		somaNumeros += numeros[i];
	}

	mediaNumeros = somaNumeros / quantidadeNumeros;

	printf("\nMaiores que a media: ");
	for (i = 0; i < quantidadeNumeros; i++)
	{

		if (numeros[i] > mediaNumeros)
		{
			printf("%.2lf ", numeros[i]);
		}
	}

	printf("\nMenores ou iguais a media: ");
	for (i = 0; i < quantidadeNumeros; i++)
	{

		if (numeros[i] <= mediaNumeros)
		{
			printf("%.2lf ", numeros[i]);
		}
	}

	printf("\nValores no vetor: ");
	for (i = 0; i < quantidadeNumeros; i++)
	{

		printf("%.2lf ", numeros[i]);
	}

	printf("\nMedia dos valores: %.2lf\n", mediaNumeros);

	return 0;
}