#include <stdio.h>

int main()
{
	int inicioIntervalo, fimIntervalo, valorAuxiliarIntervalo, somaIntervalo = 0;

	printf("Digite o primeiro valor do intervalo: ");
	scanf("%d", &inicioIntervalo);
	printf("Digite o primeiro valor do intervalo: ");
	scanf("%d", &fimIntervalo);

	if (inicioIntervalo > fimIntervalo)
	{
		valorAuxiliarIntervalo = inicioIntervalo;
		inicioIntervalo = fimIntervalo;
		fimIntervalo = valorAuxiliarIntervalo;
	}

	printf("Numeros:\n");
	
	// por ser um intervalo aberto, eu somo 1 ao inicioIntervalo para não considerar o primeiro valor nos calculos abaixo
	inicioIntervalo++;

	for (inicioIntervalo; inicioIntervalo < fimIntervalo; inicioIntervalo++)
	{

		if (inicioIntervalo % 5 == 2 || inicioIntervalo % 5 == 3)
		{
			printf("%d \n", inicioIntervalo);
			somaIntervalo += inicioIntervalo;
		}
	}

	printf("Soma dos Numeros: %d", somaIntervalo);

	return 0;
}