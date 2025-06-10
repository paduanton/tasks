# include <stdio.h>
# include <stdlib.h>
# include "data.h"

void le_data (Data *data)
{
    printf("\nDia: ");
    scanf("%d",&data->dia);

    printf("Mes:");
    scanf("%d",&data->mes);

    printf("Ano:");
    scanf("%d",&data->ano);
}

int valida_data(Data data)
{
    if (data.dia > 31 || data.ano > 2100 || data.mes > 12)
    {
        return 0;
    }

    return 1;
}

void imprime_data(Data data)
{
    printf("%d/%d/%d\n", data.dia, data.mes, data.ano);
}

int calcula_diferenca_datas(Data primeira_data, Data segunda_data)
{
    int data1, data2;

    data1 = (primeira_data.ano*365)+(primeira_data.mes*30) + primeira_data.dia;
    data2 = (segunda_data.ano*365)+(segunda_data.mes*30) + segunda_data.dia;

    if(data2 > data1) {
        return data2 - data1;
    }
    return data1 - data2;
}

Data calcula_data_pascoa(int a)
{
    Data data_pascoa;

    int c, n, k, i, j, l, m, d;

    c = a / 100;
    n = a - (19*(a/19));
    k = (c - 17)/25;
    i = c - c/4 - ((c-k)/3) +(19*n) + 15;
    i = i - (30*(i/30));
    i = i - ((i/28)*(1-(i/28))*(29/(i+1))*((21-n)/11));
    j = a + a/4 + i + 2 -c + c/4;
    j = j - (7*(j/7));
    l = i - j;
    m = 3 + ((l+40)/44);
    d = l + 28 - (31*(m/4));

    data_pascoa.ano = a;
    data_pascoa.mes = m;
    data_pascoa.dia = d;

    return data_pascoa;
}
