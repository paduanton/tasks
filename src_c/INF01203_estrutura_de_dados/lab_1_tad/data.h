struct data
{
    int dia;
    int mes;
    int ano;
};

typedef struct data Data;

void le_data (Data *data);
int calcula_diferenca_datas(Data primeira_data, Data segunda_data);
int valida_data(Data data);
void imprime_data(Data data);
Data calcula_data_pascoa(int ano);
