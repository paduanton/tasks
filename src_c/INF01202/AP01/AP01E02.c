#include <stdio.h>

int main()
{
	float primeiroValor, segundoValor, produto;

	printf("Digite o primeiro numero: ");
	scanf("%f", &primeiroValor);
	printf("Digite o segundo numero: ");
	scanf("%f", &segundoValor);

	produto = primeiroValor * segundoValor;
	printf("Resultado do produto: %.3f", produto);

	return 0;
}