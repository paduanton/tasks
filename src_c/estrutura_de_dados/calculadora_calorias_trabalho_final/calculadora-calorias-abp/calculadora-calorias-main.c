#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "calculadora-calorias-headers.h"

#define GRAMAS_BASE 100

// variáveis globais

int comp = 0;
int total_calorias = 0;

void escreve_arquivo_saida(NoABP *raiz, FILE *arquivo_saida, short codigo, char nome_arquivo_tabela_calorias[])
{
    // validacao do codigo de entrada, se igual 1, entao escrever o titulo no arquivo de saida
    if (codigo == 1)
    {
        fputs("TABELA: ", arquivo_saida);
        fputs(nome_arquivo_tabela_calorias, arquivo_saida);
        fputs("\n\n", arquivo_saida);
    }
    // caso contrario escrevemos todos os detalhes da arvore durante a execucao do programa
    else
    {
        fputs("\n", arquivo_saida);
        fputs("- Total de ", arquivo_saida);
        fprintf(arquivo_saida, "%d calorias consumidas num dia.\n\n", total_calorias);
        fputs("========== ESTATISTICAS ABP ==========\n", arquivo_saida);
        fprintf(arquivo_saida, "- Quantidade de nos: %d\n", quantidade_nos(raiz));
        fprintf(arquivo_saida, "- Quantidade de nos folhas: %d\n", quantidade_folhas(raiz));
        fprintf(arquivo_saida, "- Altura: %d\n", calcula_altura_abp(raiz));
        fprintf(arquivo_saida, "- Rotações: 0\n");
        fprintf(arquivo_saida, "- Total de comparacoes: %d\n\n", comp);
    }
}

void escreve_calculo_calorias_txt(char *nome_alimento, int calorias_base, int calorias_alimento, FILE *arquivo_saida)
{
    int calorias;
    FILE *open_arq;

    // usando regra de 3 com as calorias e gramas base para saber o total de calorias

    calorias = (calorias_alimento * calorias_base) / GRAMAS_BASE;
    total_calorias += calorias;

    // escrevemos o resultado no arquivo
    fprintf(arquivo_saida, "%dg de ", calorias_alimento);
    fputs(nome_alimento, arquivo_saida);
    fprintf(arquivo_saida, " (%d calorias por 100 gramas)", calorias_base);
    fputs(" = ", arquivo_saida);
    fprintf(arquivo_saida, "%d calorias", calorias_alimento, total_calorias);
    fputs("\n", arquivo_saida);
}

int busca_abp(NoABP *raiz, char *nome_alimento, int calorias_alimento, FILE *arquivo_saida)
{
    while (raiz != NULL)
    {
        comp++;

        /*
         se o nome do alimento informado for igual ao do alimento do nodo, escrevemos as estatisticas do alimento
         e se achar retorna 1
        */
        if (strcmp(nome_alimento, raiz->alimento.nome) == 0)
        {
            escreve_calculo_calorias_txt(nome_alimento, raiz->alimento.caloria, calorias_alimento, arquivo_saida);

            return 1;
        }

        /*
          - verificamos a ordem lexicografica do nome informado
          se a ordem lexicografica for maior que o do nodo atual, escrevemos na arvore da direita
          caso contrario botarmos na esquerda
        */
        else if (strcmp(nome_alimento, raiz->alimento.nome) > 0)
        {
            raiz = raiz->dir;
            comp++;
        }
        else
        {
            raiz = raiz->esq;
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
        3 - Lemos tabelas de calorias e inserimos na arvore binaria de pesquisa
        4 - Lemos arquivos ingeridos e escrever a saida no txt
    */
    char *nome_arquivo_tabela_calorias = argumentos[1];
    char *nome_arquivo_alimentos_ingeridos = argumentos[2];
    char *nome_arquivo_resultado_calorias_ingeridas = argumentos[3];

    if (--quantidade_argumentos != 3)
    {
        printf("Quantidade de argumentos inválida. Tente novamente\n");
        return 0;
    }

    printf("Iniciando execucao..\n");

    NoABP *arvore_alimentos = NULL;

    arvore_alimentos = ler_arquivo_tabela_calorias(arvore_alimentos, nome_arquivo_tabela_calorias);

    printf("Finalizando execucao. Aguarde...\n");

    ler_arquivo_alimentos_ingeridos(
        arvore_alimentos,
        nome_arquivo_alimentos_ingeridos,
        nome_arquivo_resultado_calorias_ingeridas,
        nome_arquivo_tabela_calorias
    );

    printf("Finalizado");

    system("pause");
    system("cls");

    return 0;
}
