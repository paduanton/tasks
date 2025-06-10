#define MAX_CARACTERES_NOME 40

typedef struct
{
  char nome[MAX_CARACTERES_NOME];
  int caloria;
} Alimento;

typedef struct Nodo
{
  Alimento alimento;
  struct Nodo *dir;
  struct Nodo *esq;
} NoABP;

int quantidade_nos(NoABP *raiz);
int calcula_altura_abp(NoABP *raiz);
NoABP *inserir_baseado_ordem_alfabetica(NoABP *raiz, Alimento a);
void imprimir_informacoes_alimento(Alimento alimento);
void ler_arquivo_alimentos_ingeridos(NoABP *raiz, char nome_arquivo_ingerido[], char nome_arquivo_saida[], char nome_arquivo[]);
NoABP *ler_arquivo_tabela_calorias(NoABP *raiz, char nome_arquivo[]);
void imprimir_versao_1(NoABP *raiz);
