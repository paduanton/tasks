#include <stdio.h>
#include <math.h>

int main()
{
    int n;

    printf("Entre com o valor de N: ");
    scanf("%d", &n);

    if (n < 0 || n > 20)
    {
        printf("Programa encerrado");
    }
    else
    {
        printf("Divisores de N\n");

        for (int i = 1; i < n; i++)
        {

            if (n != i && n % i == 0)
            {
                switch (i)
                {
                case 2:
                    printf("dois\n");
                    break;
                case 3:
                    printf("três\n");
                    break;
                case 4:
                    printf("quatro\n");
                    break;
                case 5:
                    printf("cinco\n");
                    break;
                case 6:
                    printf("seis\n");
                    break;
                case 7:
                    printf("sete\n");
                    break;
                case 8:
                    printf("oito\n");
                    break;
                case 9:
                    printf("nove\n");
                    break;
                case 10:
                    printf("dez\n");
                    break;
                }
            }
        }
    }

    return 0;
}
