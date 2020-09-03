#include <math.h>
#include <stdio.h>
#include <string.h>

int main()
{
    int n, primeiroDigito, segundoDigito;

    printf("Entre com o valor de N: ");
    scanf("%d", &n);

    if (n < 20 || n > 49)
    {
        printf("Programa encerrado");
    }
    else
    {
        primeiroDigito = n / 10;
        segundoDigito = n % 10;

        printf("Soma dos algarismos: %d", primeiroDigito + segundoDigito);
        printf("\nExtenso: ");

        switch (primeiroDigito)
        {
        case 2:
            printf("vinte");
            break;
        case 3:
            printf("trinta");
            break;
        case 4:
            printf("quarenta");
            break;
        }

        switch (segundoDigito)
        {
        case 1:
            printf(" e um");
            break;
        case 2:
            printf(" e dois");
            break;
        case 3:
            printf(" e três");
            break;
        case 4:
            printf(" e quatro");
            break;
        case 5:
            printf(" e cinco");
            break;
        case 6:
            printf(" e seis");
            break;
        case 7:
            printf(" e sete");
            break;
        case 8:
            printf(" e oito");
            break;
        case 9:
            printf(" e nove");
            break;
        }
    }

    return 0;
}
