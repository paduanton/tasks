#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "calculadora-calorias-headers.h"

#define GRAMAS_BASE 100

// variaveis globais

int totalCalorias = 0;
int rotacoes_direita = 0;
int rotacoes_direita_e_esquerda = 0;
int rotacoes_esquerda = 0;
int rotacoes_esquerda_e_direita = 0;
int comp = 0;

void escreve_calculo_calorias_txt(char *nome_alimento, int calorias_base, int alimento_calorias, FILE *arquivo_saida)
{
    int calorias;

    // usando regra de 3 com as calorias e gramas base para saber o total de calorias

    calorias = (alimento_calorias * calorias_base) / GRAMAS_BASE;
    totalCalorias += calorias;

    // escrevemos o resultado no arquivo
    fprintf(arquivo_saida, "%dg de ", alimento_calorias);
    fputs(nome_alimento, arquivo_saida);
    fprintf(arquivo_saida, " (%d calorias por 100 gramas)", calorias_base);
    fputs(" = ", arquivo_saida);
    fprintf(arquivo_saida, "%d calorias", alimento_calorias, calorias);
    fputs("\n", arquivo_saida);
}

void escreve_arquivo_saida(NodoAVL *raiz_arvore, FILE *arquivo_saida, short codigo, char nome_arquivo[])
{
    // validacao do codigo de entrada, se igual 1, entao escrever o titulo no arquivo de saida
    if (codigo == 1)
    {
        fputs("TABELA: ", arquivo_saida);
        fputs(nome_arquivo, arquivo_saida);
        fputs("\n\n", arquivo_saida);
    }
    // caso contrario escrevemos todos os detalhes da arvore durante a execucao do programa
    else
    {
        fputs("\n", arquivo_saida);
        fputs("- Total de ", arquivo_saida);
        fprintf(arquivo_saida, "%d calorias consumidas num dia.\n\n", totalCalorias);
        fputs("========== ESTATISTICAS AVL ==========\n", arquivo_saida);
        fprintf(arquivo_saida, "Quantidade de Nodos: %d\n", quantidade_nodos(raiz_arvore));
        fprintf(arquivo_saida, "Quantidade de Nodos folhas: %d\n", quantidade_folhas_arvore(raiz_arvore));
        fprintf(arquivo_saida, "Altura: %d\n", calcula_altura_avl(raiz_arvore));
        fprintf(arquivo_saida, "Quantidade de Rotacoes direita-esquerda: %d\n", rotacoes_direita_e_esquerda);
        fprintf(arquivo_saida, "Quantidade de Rotacoes a esquerda: %d\n", rotacoes_esquerda);
        fprintf(arquivo_saida, "Quantidade de Rotacoes esquerda-direita: %d\n", rotacoes_esquerda_e_direita);
        fprintf(arquivo_saida, "Quantidade de Rotacoes a direita: %d\n", rotacoes_direita);

        fprintf(arquivo_saida, "Comparacoes: %d\n\n", comp);
    }
}
NodoAVL *rotacao_direita(NodoAVL *nodo, short codigo)
{
    NodoAVL *proximoNodo, *nodoNulo;

    if (codigo == 0)
    {
        rotacoes_direita++;
    }

    proximoNodo = nodo->esq;
    nodoNulo = proximoNodo->dir;

    proximoNodo->dir = nodo;
    nodo->esq = nodoNulo;

    nodo->altura = calcula_maior_nodo(calcula_altura_nodo(nodo->esq), calcula_altura_nodo(nodo->dir)) + 1;
    proximoNodo->altura = calcula_maior_nodo(calcula_altura_nodo(proximoNodo->esq), calcula_altura_nodo(proximoNodo->dir)) + 1;

    return proximoNodo;
}

NodoAVL *rotacao_esquerda(NodoAVL *nodo, short codigo)
{
    NodoAVL *proximoNodo, *nodoNulo;

    if (codigo == 0)
    {
        rotacoes_esquerda++;
    }

    proximoNodo = nodo->dir;
    nodoNulo = proximoNodo->esq;

    proximoNodo->esq = nodo;

    nodo->dir = nodoNulo;
    nodo->altura = calcula_maior_nodo(calcula_altura_nodo(nodo->esq), calcula_altura_nodo(nodo->dir)) + 1;

    proximoNodo->altura = calcula_maior_nodo(calcula_altura_nodo(proximoNodo->esq), calcula_altura_nodo(proximoNodo->dir)) + 1;

    return proximoNodo;
}
NodoAVL *rotacao_direita_e_esquerda(NodoAVL *nodo)
{
    rotacoes_direita_e_esquerda++;

    nodo->dir = rotacao_direita(nodo->dir, 1);

    return rotacao_esquerda(nodo, 1);
}

NodoAVL *rotacao_esquerda_e_direita(NodoAVL *nodo)
{
    rotacoes_esquerda_e_direita++;

    nodo->esq = rotacao_esquerda(nodo->esq, 1);

    return rotacao_direita(nodo, 1);
}

int busca_avl(NodoAVL *raiz_arvore, char *nome_alimento, int porcao, FILE *arquivo_saida)
{
    while (raiz_arvore != NULL)
    {
        comp++;
        /*
         se o nome do alimento informado for igual ao do alimento do nodo, escrevemos as estatisticas do alimento
         e se achar retorna 1
        */

        if (strcmp(nome_alimento, raiz_arvore->alimento.nome) == 0)
        {
            escreve_calculo_calorias_txt(nome_alimento, raiz_arvore->alimento.caloria, porcao, arquivo_saida);
            return 1;
        }
        /*
          - verificamos a ordem lexicografica do nome informado
          se a ordem lexicografica for maior que o do nodo atual, escrevemos na arvore da direita
          caso contrario botarmos na esquerda
        */
        else if (strcmp(nome_alimento, raiz_arvore->alimento.nome) > 0)
        {
            raiz_arvore = raiz_arvore->dir;
            comp++;
        }
        else
        {
            raiz_arvore = raiz_arvore->esq;
        }
    }
    return 0;
}

// Referencia para passagem de argumentos na funcao main: https://www.tutorialspoint.com/cprogramming/c_command_line_arguments.htm

int main(int quantidade_argumentos, char *argumentos[])
{
    /*
        Estrutura da main:

        1 - Lemos os informacoes de argumentos recebidas pela funcao main
        2 - Validamos a quantidade correta do parametros, se tudo certo, deixamos seguir
        3 - Lemos tabelas de calorias e inserimos na AVL
        4 - Lemos arquivos ingeridos e escrevemos a saida nodo txt
    */

    char *nome_arquivo_tabela_calorias = argumentos[1];
    char *nome_arquivo_alimentos_ingeridos = argumentos[2];
    char *nome_arquivo_resultado_calorias_ingeridas = argumentos[3];

    if (--quantidade_argumentos != 3)
    {
        printf("Quantidade de argumentos inválida. Tente novamente\n");
        return 0;
    }

    printf("Iniciando execucao..\n\n");

    NodoAVL *arvore_alimentos = NULL;

    arvore_alimentos = ler_arquivo_tabela_calorias(arvore_alimentos, nome_arquivo_tabela_calorias);

    printf("Finalizando execucao. Aguarde...\n\n");

    ler_arquivo_alimentos_ingeridos(
        arvore_alimentos,
        nome_arquivo_alimentos_ingeridos,
        nome_arquivo_resultado_calorias_ingeridas,
        nome_arquivo_tabela_calorias);

    printf("\n\nFinalizado!\n\n");

    system("pause");
    system("cls");

    return 0;
}
