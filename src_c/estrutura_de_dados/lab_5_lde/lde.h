struct Produto
{
    int codigo;
    char nome[35];
    float preco;
};

typedef struct Produto Produto;

struct Nodo
{
    Produto produto;
    struct Nodo* anterior;
    struct Nodo* proximo;
};
typedef struct Nodo Nodo;

Nodo* inicializar(void);
void imprimir(Nodo* lista);
void imprimir_reverso(Nodo *lista);
Nodo* inserir_inicio(Nodo *lista, Produto produto);
Nodo* inserir_fim(Nodo *lista, Produto produto);
Nodo* inserir_ordenado(Nodo *lista, Produto produto);
Nodo* destruir(Nodo* lista);
Nodo* remover(Nodo *lista, int codigo);
void ler_produto(Produto *produto);
