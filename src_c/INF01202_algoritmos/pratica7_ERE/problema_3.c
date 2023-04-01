#include <stdio.h>

#define MAXLIDOS 15

int main()
{

    float entradaNumeros[MAXLIDOS], media = 0, soma;
    int i = 0, maioresMedia = 0, menoresMedia = 0;

    printf("Entre os valores: ");

    while (i <= 15)
    {
        scanf("%f", &entradaNumeros[i]);

        if (entradaNumeros[i] < 0)
        {
            break;
        }

        soma += entradaNumeros[i];
        i++;
    }

    media = (soma / i);

    for (int j = 0; j < i; j++)
    {

        if (entradaNumeros[j] > media)
        {
            maioresMedia++;
        }
        else if (entradaNumeros[i] < media)
        {
            menoresMedia++;
        }
    }

    printf("\nMédia dos valores: %f", media);
    printf("\nQuantidade de valores maiores do que a media: %d", maioresMedia);
    printf("\nQuantidade de valores menores do que a media: %d", menoresMedia);
}