#include <stdio.h>

int main()
{
	// quebrando as variaveis double em duas linhas para facilitar a leitura
	double valorDoacaoAtual, metaValorTotalDoacoes, valorTotalDoacoes = 0;
	/* 
	   inicializando menorValorDoacao com o maior numero possivel para double
	   para ser feita a comparacao da linha 37
	*/
	double menorValorDoacao = 1.7976931348623158E+308, maiorValorDoacao = 0, mediaDoacoes;
	int quantidadeDoacoes = 0;

	printf("Digite a meta do valor total das doacoes: ");
	scanf("%lf", &metaValorTotalDoacoes);

	while (valorTotalDoacoes < metaValorTotalDoacoes)
	{

		printf("Digite o valor a ser doado: ");
		scanf("%lf", &valorDoacaoAtual);

		if (valorDoacaoAtual <= 0)
		{
			printf("Doação invalida de R$%.2lf", valorDoacaoAtual);
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