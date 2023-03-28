struct Produto
{
    int codigo;
    char nome[15];
    int preco;
};
typedef struct Produto Produto;

struct info_no
{
    Produto info;
    struct info_no * prox;
};
typedef struct info_no TipoPtNo;

void ler_produtos(Produto *dados);
TipoPtNo* Inicializa_Lista(void);
TipoPtNo* Insere_Produto(TipoPtNo* ptLista, Produto dados);
void imprimir_produtos(TipoPtNo* ptLista);

