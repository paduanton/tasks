#include <stdio.h>
#include <stdlib.h>

typedef struct TPtPilha Pilha;
typedef int Info;

Pilha* InicializaPilha (void);
int PilhaVazia (Pilha *pilha);
void ImprimirPilha (Pilha *pilha);
Pilha* PushPilha (Pilha *pilha, Info info);
int PopPilha (Pilha **pilha, Info *info);
Info ConsultaPilha (Pilha *pilha);
Pilha* DestroiPilha (Pilha *pilha);
int compara (Pilha *pilha1, Pilha *pilha2);

