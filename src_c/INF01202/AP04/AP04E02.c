#include <stdio.h>

int main()
{
	char sexo;
	double salario, salarioMaximo = 0;
	float somaIdade = 0, mediaIdade;
	int i, quantidadePessoasEntrevistadas, idade, quantidadeHomens = 0, quantidadeMulheres = 0;

	printf("Digite a quantidade de pessoas entrevistadas: ");
	scanf("%d", &quantidadePessoasEntrevistadas);
	printf("\n");

	for (i = 0; i < quantidadePessoasEntrevistadas; i++)
	{

		printf("Digite o sexo - Pessoa %d: ", i + 1);
		scanf(" %c", &sexo);
		printf("Digite o salario - Pessoa %d: ", i + 1);
		scanf("%lf", &salario);
		printf("Digite a idade - Pessoa %d: ", i + 1);
		scanf("%d", &idade);

		printf("\n");

		somaIdade += idade;

		if (salario > salarioMaximo)
		{
			salarioMaximo = salario;
		}

		if (sexo == "M")
		{
			quantidadeHomens++;
		}
		else
		{
			quantidadeMulheres++;
		}
	}

	mediaIdade = somaIdade / quantidadePessoasEntrevistadas;

	printf("Media de idades %.1f\n", mediaIdade);
	printf("Numero de mulheres: %d\n", quantidadeMulheres);
	printf("Numero de homens: %d\n", quantidadeHomens);
	printf("Salario maximo: %.2lf", salarioMaximo);

	return 0;
}