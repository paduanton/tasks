typedef struct T_Descritor
{
    int inicio;
    int fim;
} TDescritor;

typedef struct Desempregados
{
    char nome[15];
    int codigo;
}

void inicializa_fila(Desempregados fila_desempregados[], TDescritor *descritor);

int insere_fila(Desempregados fila_desempregados[], TDescritor *descritor, int posicao);

Fila consulta_fila(Desempregados fila_desempregados[], TDescritor descritor, int posicao);

int remove_fila(Desempregados fila_desempregados[], TDescritor *descritor, int posicao);

/* 
    seleciona um elemento da fila Desempregados e retorna o codigo dele

*/

int seleciona_um_desempregado(Desempregados fila_desempregados[]);

/*
    dado uma fila de Desempregados e duas posicoes dela, faz a comparacao entre os dois elementos,
    retornando 1 caso sejam iguais e 0 caso contrario, aqui tambem eh possivel implementar a atribuicao de cargos,
    caso as duas posicoes informadas sejam iguais eh designado politico, caso contrario os dois sao estagiarios

    em seguida eh usado o remove_fila para tirar os elementos da fila
*/
int compara_desempregados(Desempregados fila_desempregados[], int codigo_primeiro_desempregado, int codigo_segundo_desempregado);
