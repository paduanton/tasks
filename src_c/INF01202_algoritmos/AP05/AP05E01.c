#include <stdio.h>

#define MAX_DOUBLE_NUMBER 1.7976931348623158E+308;

int main()
{
	// quebrando as variaveis double em mais de uma linha para facilitar a leitura
	double valorDoacaoAtual, metaValorTotalDoacoes, valorTotalDoacoes = 0;
	/*
	   inicializando menorValorDoacao com o maior numero possivel de double
	   para ser feita a comparacao da linha 39
	*/
	double menorValorDoacao = MAX_DOUBLE_NUMBER;
	double maiorValorDoacao = 0, mediaDoacoes;
	int quantidadeDoacoes = 0;

	printf("Digite a meta do valor total das doacoes: ");
	scanf("%lf", &metaValorTotalDoacoes);

	while (valorTotalDoacoes < metaValorTotalDoacoes)
	{
		printf("Digite o valor a ser doado: ");
		scanf("%lf", &valorDoacaoAtual);

		if (valorDoacaoAtual <= 0)
		{
			printf("Doação invalida de R$%.2lf\n", valorDoacaoAtual);
		}
		else
		{
			quantidadeDoacoes++;
			valorTotalDoacoes += valorDoacaoAtual;

			if (valorDoacaoAtual > maiorValorDoacao)
			{
				maiorValorDoacao = valorDoacaoAtual;
			}

			if (valorDoacaoAtual < menorValorDoacao)
			{
				menorValorDoacao = valorDoacaoAtual;
			}
		}
	}

	mediaDoacoes = valorTotalDoacoes / quantidadeDoacoes;

	printf("\nArrecadacao total R$%.2lf", valorTotalDoacoes);
	printf("\nMenor doacao: R$%.2lf", menorValorDoacao);
	printf("\nMaior doacao: R$%.2lf", maiorValorDoacao);
	printf("\nMedia das doacoes: R$%.2lf", mediaDoacoes);

	return 0;
}