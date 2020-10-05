#include <stdio.h>
#include <math.h>

int main()
{
    int divisor, divisor1 = 1, divisor2 = 2, i = 1, expoente = 1;
    float x, tolerancia, resultado = 0, termo = 90, numerador;

    printf("Entre com o valor de x: ");
    scanf("%f", &x);

    if (x < -1 || x > 1)
    {
        printf("Valor de x fora do intervalo!");
    }
    else
    {
        printf("Entre com o valor de tolerancia: ");
        scanf("%f", &tolerancia);

        while (fabs(termo) >= tolerancia)
        {

            numerador = pow(x, expoente);
            divisor = divisor1 * divisor2;

            termo = numerador / divisor;

            if (fabs(termo) >= tolerancia)
            {
                divisor1 += 2;
                divisor2 += 2;
                expoente += 2;

                if (i % 2 == 0)
                {
                    resultado -= termo;
                }
                else
                {
                    resultado += termo;
                }

                i++;
            }
        }

        printf("o resultado foi %f", resultado);
    }

    return 0;
}
