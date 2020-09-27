#include <stdio.h>

int main()
{
    int termos = 0;
    float pi = 0, divisor = 1;

    printf("Entre com o numero de termos para calculo de PI: ");
    scanf("%d", &termos);

    if (termos < 2)
    {
        printf("\nValor mínimo é 2. Programa encerrado.");
    }
    else
    {
        for (int i = 1; i <= termos; i++)
        {
            divisor += 2;

            if (i % 2 == 0)
            {
                pi -= 4 / divisor;
            }
            else
            {
                pi += 4 / divisor;
            }
        }

        pi = 4 - pi;

        printf("\nValor de PI com %d termos: %f", termos, pi);
    }

    return 0;
}
