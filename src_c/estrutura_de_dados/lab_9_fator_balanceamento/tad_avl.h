
struct TNodoA
{
    int info;
    int FB;
    struct TNodoA *esquerda;
    struct TNodoA *direita;
};
typedef struct TNodoA NodoAVL;

int altura (NodoAVL *a);
void imprimir_arvore (NodoAVL *arvore, int aux);
NodoAVL* inserir_arvore(NodoAVL *arvore, int ch);
void calcula_maior_fator(NodoAVL *arvore, int *maior);
void calcula_maior_fator(NodoAVL *arvore, int *maior);
int calcula_fator(NodoAVL *arvore);
