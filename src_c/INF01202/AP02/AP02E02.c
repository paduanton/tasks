#include <stdio.h>

int main()
{
	float valorTotal, valorPaoFatiado = 1.50, valorLeite = 4.65, valorBiscoito = 6.93;
	int codigoProduto, quantidadeProduto;

	printf("Codigo do Produto | Descricao do Produto | Valor unitario\n");
	printf("1                 | Pão Fatiado          | R$ 1,50\n");
	printf("2                 | Leite (1 litro)      | R$4,65\n");
	printf("3                 | Biscoito (pacote 300 gramas) | R$6,93\n\n");

	printf("Digite o codigo do produto: ");
	scanf("%d", &codigoProduto);
	printf("\nDigite a quantidade de produtos: ");
	scanf("%d", &quantidadeProduto);

	if (codigoProduto == 1)
	{
		valorTotal = valorPaoFatiado * quantidadeProduto;
	}
	else if (codigoProduto == 2)
	{
		valorTotal = valorLeite * quantidadeProduto;
	}
	else
	{
		valorTotal = valorBiscoito * quantidadeProduto;
	}

	printf("Total a pagar: %.2f", valorTotal);

	return 0;
}