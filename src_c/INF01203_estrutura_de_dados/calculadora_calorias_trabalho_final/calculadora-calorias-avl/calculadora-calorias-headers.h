#define MAX_CARACTERES_NOME 40

typedef struct
{
    int caloria;
    char nome[MAX_CARACTERES_NOME];
} Alimento;

typedef struct Nodo
{
    Alimento alimento;
    struct Nodo *dir;
    struct Nodo *esq;
    int altura;
} NodoAVL;

int calcula_altura_avl(NodoAVL *raiz);
int quantidade_nodos(NodoAVL *raiz);
int quantidade_folhas_arvore(NodoAVL *raiz);
int calcula_altura_nodo(NodoAVL *no);
int calcula_maior_nodo(int no1, int no2);
NodoAVL *inicializa_nodo(Alimento a);
void escreve_arquivo_saida(NodoAVL *raiz, FILE *arq_exit, short flag, char nomeArquivo[]);
void ler_arquivo_alimentos_ingeridos(
    NodoAVL *raiz, char nome_arquivo_alimentos_ingeridos[],
     char nome_arquivo_saida[], char nomeArquivo[]
);
NodoAVL *ler_arquivo_tabela_calorias(NodoAVL *raiz, char nomeArquivo[]);
Alimento ler_alimento(char *nomeAlimento, int calAlimento);
NodoAVL *inserir_nodo_ordem_alfabetica(NodoAVL *raiz, Alimento a);
NodoAVL *balanceamento_arvore(NodoAVL *raiz);
