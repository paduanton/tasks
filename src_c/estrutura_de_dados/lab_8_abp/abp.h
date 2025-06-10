struct Nodo{
    int info;
    struct Nodo *esquerda;
    struct Nodo *direita;
};
typedef struct Nodo pNodoA;

pNodoA* inserirArvore(pNodoA *a, int ch);
void imprimirCaminhamentoPreFixado(pNodoA *a);
int contaNodos (pNodoA *a);
void imprimirArvore (pNodoA *a, int contadorAuxiliar);
