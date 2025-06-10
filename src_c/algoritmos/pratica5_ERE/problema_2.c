#include <stdio.h>

int main()
{
    int valor = 0, totalAprovados = 0, totalReprovados = 0;

    for (int i = 1; i <= 10; i++)
    {
        printf("\nDigite um valor: ");
        scanf("%d", &valor);

        if (valor == 1)
        {
            totalReprovados++;
        }
        else if (valor == 2)
        {
            totalAprovados++;
        }
    }

    printf("\nAlunos aprovados: %d", totalAprovados);
    printf("\nAlunos reprovados: %d", totalReprovados);

    if (totalAprovados > 8)
    {
        printf("\nBônus para o instrutor!");
    }

    return 0;
}
