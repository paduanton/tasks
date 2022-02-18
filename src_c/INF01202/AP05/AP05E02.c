#include <stdio.h>
#include <math.h>

#define CODIGO_SOMA 1
#define CODIGO_SUBTRACAO 2
#define CODIGO_MULTIPLICACAO 3
#define CODIGO_DIVISAO 4
#define CODIGO_RESTO_DIVISAO 5
#define CODIGO_SAIR 0

int main()
{
	int codigoAcao;
	float primeiroOperando, segundoOperando, resultado;

	do
	{
		printf("\nDigite o numero de uma opcao abaixo:");
		printf("\n1) Soma");
		printf("\n2) Subtracao");
		printf("\n3) Multiplicacao");
		printf("\n4) Divisao");
		printf("\n5) Resto da divisao");
		printf("\n0) Sair do programa\n\n");

		scanf("%d", &codigoAcao);

		/* Validando se é um codigo valido para pedir os operandos ao usuario.
		   Conforme o exemplo do enunciado, nao deve pedir operando caso operacao
		   seja invalida ou codigo 0
		*/
		if (codigoAcao >= CODIGO_SOMA && codigoAcao <= CODIGO_RESTO_DIVISAO)
		{
			printf("\nDigite o primeiro operando: ");
			scanf("%f", &primeiroOperando);
			printf("Digite o segundo operando: ");
			scanf("%f", &segundoOperando);
		}
		switch (codigoAcao)
		{
		case CODIGO_SOMA:
			resultado = primeiroOperando + segundoOperando;
			break;
		case CODIGO_SUBTRACAO:
			resultado = primeiroOperando - segundoOperando;
			break;
		case CODIGO_MULTIPLICACAO:
			resultado = primeiroOperando * segundoOperando;
			break;
		case CODIGO_DIVISAO:
			if (segundoOperando == 0)
			{
				printf("\nNao e possivel divisao por zero\n");
			}
			else
			{
				resultado = primeiroOperando / segundoOperando;
			}
			break;
		case CODIGO_RESTO_DIVISAO:
			resultado = fmodf(primeiroOperando, segundoOperando);
			break;
		case CODIGO_SAIR:
			printf("\nEncerrando o programa\n");
			break;

		default:
			printf("\nOpcao invalida\n\n");
			break;
		}
		/* Validando se é um codigo valido para mostrar o printf com o resultado.
		   Assim evitando redudancias de botar um printf em cada case acima.
		   Conforme o exemplo do enunciado, nao deve mostrar resultado caso operacao
		   seja invalida ou codigo 0
		*/
		if (codigoAcao >= CODIGO_SOMA && codigoAcao <= CODIGO_RESTO_DIVISAO)
		{
			/* Conforme enunciado, caso operacao seja divisao e segundo operando
			   seja 0, não deve mostrar o resultado
			*/
			if (!(codigoAcao == CODIGO_DIVISAO && segundoOperando == 0))
			{
				printf("\nResultado: %.1f\n\n", resultado);
			}
		}

	} while (codigoAcao != CODIGO_SAIR);

	return 0;
}