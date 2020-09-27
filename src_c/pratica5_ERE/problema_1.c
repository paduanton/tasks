#include <stdio.h>
#include <math.h>

int main()
{
    float rendaTotal = 0, totalRendaTotal = 0, totalPessoasResidencia = 0;
    int pessoasResidencia = 0, totalAcessoInternet = 0;
    char acessoInternet;

    for (int i = 1; i <= 5; i++)
    {
        printf("\nQuantas pessoas moram na residencia? ");
        scanf("%d", &pessoasResidencia);
        printf("Qual a renda total da moradia? ");
        scanf("%f", &rendaTotal);
        printf("Possui acesso a internet? (S/N) ");
        scanf(" %c", &acessoInternet);

        totalPessoasResidencia += pessoasResidencia;
        totalRendaTotal += rendaTotal;

        if (acessoInternet == 'S' || acessoInternet == 's')
        {
            totalAcessoInternet++;
        }
    }

    printf("\nNro medio de pessoas por residencia: %f", totalPessoasResidencia / 5);
    printf("\nRenda mensal media: %f", (totalRendaTotal / 5));
    printf("\nNro de moradias com acesso a internet = %d", totalAcessoInternet);

    return 0;
}
