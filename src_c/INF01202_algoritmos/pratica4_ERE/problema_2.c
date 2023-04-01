#include <stdio.h>
#include <math.h>

int main()
{
    int placa, ultimoDigito;

    printf("Entre com a placa: ");
    scanf("%d", &placa);

    if (placa < 1000 || placa > 9999)
    {
        printf("Programa encerrado");
    }
    else
    {
        ultimoDigito = placa % 10;

        switch (ultimoDigito)
        {
        case 0:
            printf("Outubro");
            break;
        case 1:
            printf("Janeiro");
            break;
        case 2:
            printf("Fevereiro");
            break;
        case 3:
            printf("Março");
            break;
        case 4:
            printf("Abril");
            break;
        case 5:
            printf("Maio");
            break;
        case 6:
            printf("Junho");
            break;
        case 7:
            printf("Julho");
            break;
        case 8:
            printf("Agosto");
            break;
        case 9:
            printf("Setembro");
            break;
        }
    }

    return 0;
}
