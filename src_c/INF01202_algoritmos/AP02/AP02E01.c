#include <stdio.h>

int main()
{
	float media, nota1, nota2, nota3;

	printf("Digite a primeira nota do aluno: ");
	scanf("%f", &nota1);
	printf("Digite a segunda nota do aluno: ");
	scanf("%f", &nota2);
	printf("Digite a terceira nota do aluno: ");
	scanf("%f", &nota3);

	media = (nota1 * 2 + nota2 * 2 + nota3 * 3) / (2 + 2 + 3);

	printf("\nMedia: %.1f\n", media);

	if (media >= 6)
	{
		printf("Aluno aprovado");
	}
	else
	{
		printf("Aluno reprovado");
	}

	return 0;
}