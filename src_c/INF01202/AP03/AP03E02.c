#include <stdio.h>

int main()
{
	double saldoInicial, saldoFinal, valorOperado;
	int codigoOperacao, numeroConta;

	printf("Digite o saldo: ");
	scanf("%lf", &saldoInicial);
	printf("Digite o codigo da operacao: ");
	scanf("%d", &codigoOperacao);
	printf("Digite o valor a ser operado: ");
	scanf("%lf", &valorOperado);

	switch (codigoOperacao)
	{
	case 1:
		saldoFinal = saldoInicial + valorOperado;
		break;
	case 2:
		if (saldoInicial >= valorOperado)
		{
			saldoFinal = saldoInicial - valorOperado;
		}
		else
		{
			saldoFinal = saldoInicial;
			printf("Saldo insuficiente para realizar a operacao");

			break;
		}
	case 3:
		printf("Digite o numero da conta: ");
		scanf("%d", &numeroConta);

		if (saldoInicial >= valorOperado)
		{
			saldoFinal = saldoInicial - valorOperado;
		}
		else
		{
			saldoFinal = saldoInicial;
			printf("Saldo insuficiente para realizar a operacao");
		}
		break;

	default:
		break;
	}

	printf("\nSaldo Final: R$%.2f", saldoFinal);

	return 0;
}