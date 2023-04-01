#include <stdio.h>
#include <string.h>

#define QUANTIDADE_CARACTERES_NOME_PACOTE 20
#define QUANTIDADE_PACOTES 4
#define QUANTIDADE_VENDEDORES 3

int main()
{
    int i, j, codigoTemporarioVendedor, quantidadeVendas;
    char nomePacote[QUANTIDADE_PACOTES][QUANTIDADE_CARACTERES_NOME_PACOTE + 2]; // + 2 para o '\n' e o '\0'
    int codigoVendedor[QUANTIDADE_VENDEDORES], vendedoresVendas[QUANTIDADE_VENDEDORES][QUANTIDADE_PACOTES];

    for (i = 0; i < QUANTIDADE_PACOTES; i++)
    {
        printf("Informe o nome do pacote #%d: ", i + 1);
        fgets(nomePacote[i], QUANTIDADE_CARACTERES_NOME_PACOTE, stdin);

        // retirando '\n'
        nomePacote[i][strlen(nomePacote[i]) - 1] = '\0';
    }

    printf("\n");
    printf("\n");

    for (i = 0; i < QUANTIDADE_VENDEDORES; i++)
    {
        printf("Informe o codigo do vendedor #%d: ", i + 1);
        scanf("%d", &codigoVendedor[i]);

        for (j = 0; j < QUANTIDADE_PACOTES; j++)
        {
            printf("Informe a quantidade de vendas do vendedor %d para o pacote %s: ", codigoVendedor[i], nomePacote[j]);
            scanf("%d", &quantidadeVendas);

            vendedoresVendas[i][j] = quantidadeVendas;
        }
        printf("\n");
    }

    printf("%*s%*s%*s\n", -QUANTIDADE_CARACTERES_NOME_PACOTE, "Pacote", -QUANTIDADE_CARACTERES_NOME_PACOTE, "Codigo Vendedor", -QUANTIDADE_CARACTERES_NOME_PACOTE, "Quantidade");

    // para cada vendedor mostra o nome do pacote e as vendas realizadas por ele
    for (i = 0; i < QUANTIDADE_VENDEDORES; i++)
    {
        for (j = 0; j < QUANTIDADE_PACOTES; j++)
        {
            printf("%*s%*d%*d\n", -QUANTIDADE_CARACTERES_NOME_PACOTE, nomePacote[j], -QUANTIDADE_CARACTERES_NOME_PACOTE, codigoVendedor[i], -QUANTIDADE_CARACTERES_NOME_PACOTE, vendedoresVendas[i][j]);
        }
    }

    return 0;
}