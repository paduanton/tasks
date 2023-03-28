# include <stdio.h>
# include <stdlib.h>
# include "data.h"

int main (void)
{
    int diferenca_datas, ano_pascoa;
    Data primeira_data, segunda_data, pascoa;

    printf("Digite data inicial");
    le_data(&primeira_data);

    printf("\nDigite data final");
    le_data(&segunda_data);

    diferenca_datas = calcula_diferenca_datas(primeira_data, segunda_data);
    printf("\nDiferenca entre as datas: %d \n", diferenca_datas);

    printf("\nDigite um ano para descobrir em qual dia sera a pascoa:\n");
    scanf("%d", &ano_pascoa);

    pascoa = calcula_data_pascoa(ano_pascoa);

    printf("\n");
    imprime_data(pascoa);

    return 0;
}
