#include <stdio.h>

int main()
{
    int maiorValor, menorValor, numero, count = 0;

    while (numero != 9999)
    {
        count++;

        printf("Entre com um nro inteiro: ");
        scanf("%d", &numero);

        if (count == 1)
        {
            maiorValor = numero;
            menorValor = numero;
        }

        if (numero != 9999)
        {
            if (numero > maiorValor)
            {
                maiorValor = numero;
            }

            if (numero < menorValor)
            {
                menorValor = numero;
            }
        }
    }

    printf("O maior valor vale %d e o menor valor vale %d", maiorValor, menorValor);

    return 0;
}
