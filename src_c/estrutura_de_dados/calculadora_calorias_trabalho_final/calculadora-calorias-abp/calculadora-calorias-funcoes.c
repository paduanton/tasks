#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include "calculadora-calorias-headers.h"

#define MAX_CARACTERES_NOME 40

// funcao que retorna uma estrutura basica de alimento

Alimento ler_alimento(char *nome_alimento, int calorias_alimento)
{
    Alimento alimento;

    alimento.caloria = calorias_alimento;
    strcpy(alimento.nome, nome_alimento);

    return alimento;
}



int calcula_altura_abp(NoABP *raiz)
{
    // calculamos recursivamente pros nos da esquerda e direita

    if (raiz == NULL)
    {
        return -1;
    }

    int esq = calcula_altura_abp(raiz->esq);
    int dir = calcula_altura_abp(raiz->dir);

    if (esq > dir)
    {
        return esq + 1;
    }

    return dir + 1;
}

int quantidade_nos(NoABP *raiz)
{
    if (raiz == NULL)
    {
        return 0;
    }
    else
    {
        // raiz + nos esquerda e direita
        return 1 + quantidade_nos(raiz->esq) + quantidade_nos(raiz->dir);
    }
}

int quantidade_folhas(NoABP *raiz)
{
    // arvore vazia, entao retorna 0
    if (raiz == NULL)
    {

        return 0;
    }
    // raiz sem filhos entao retorna 1
    else if (raiz->esq == NULL && raiz->dir == NULL)
    {
        return 1;
    }

    // caso contrario aplicamos recursivamente para esq e direita
    return quantidade_folhas(raiz->esq) + quantidade_folhas(raiz->dir);
}

// Referência para estrutura de leitura de arquivos .csv: https://stackoverflow.com/questions/12911299/read-csv-file-in-c

NoABP *ler_arquivo_tabela_calorias(NoABP *raiz, char nome_arquivo[])
{
    char *texto[MAX_CARACTERES_NOME], nome_alimento[MAX_CARACTERES_NOME], *linha_texto_auxiliar;
    int calorias, iteracao = 0;

    FILE *arquivo_tabela_calorias;

    // abertura do arquivo de calorias
    arquivo_tabela_calorias = fopen(nome_arquivo, "r");

    // repeticao até chegar fimfinal do aqruivo e a quebra de texto

    while (EOF != fscanf(arquivo_tabela_calorias, "%[^\n]\n", texto))
    {
        linha_texto_auxiliar = strtok(texto, ";");
        while (linha_texto_auxiliar != NULL)
        {
            // se igual zero, faz a leitura do alimento, caso contrario faz a leitura da caloria e insere na arvore
            if (iteracao == 0)
            {
                iteracao = 1;
                strcpy(nome_alimento, linha_texto_auxiliar);
            }
            else
            {
                calorias = atoi(linha_texto_auxiliar);

                raiz = inserir_baseado_ordem_alfabetica(raiz, ler_alimento(nome_alimento, calorias));

                iteracao = 0;
            }
            linha_texto_auxiliar = strtok(NULL, ";");
        }
    }

    fclose(arquivo_tabela_calorias);

    return raiz;
}

NoABP *inserir_baseado_ordem_alfabetica(NoABP *raiz, Alimento a)
{
    if (raiz == NULL)
    {
        NoABP *linha_texto_auxiliar = malloc(sizeof(NoABP));

        linha_texto_auxiliar->alimento = a;
        linha_texto_auxiliar->esq = NULL;
        linha_texto_auxiliar->dir = NULL;

        return linha_texto_auxiliar;
    }
    else
    {
        // se a raiz nao for nula, fazemos as comparacoes para inserir em ordem alfabetica recursivamente
        if (strcmp(a.nome, raiz->alimento.nome) < 0)
        {
            raiz->esq = inserir_baseado_ordem_alfabetica(raiz->esq, a);
        }
        else if (strcmp(a.nome, raiz->alimento.nome) > 0)
        {
            raiz->dir = inserir_baseado_ordem_alfabetica(raiz->dir, a);
        }

        return raiz;
    }
}

void imprimir_informacoes_alimento(Alimento alimento)
{
    printf("\tAlimento: %s\t - Calorias: %d\n", alimento.nome, alimento.caloria);
}

void ler_arquivo_alimentos_ingeridos(NoABP *raiz, char nome_arquivo_ingerido[], char nome_arquivo_saida[], char nome_arquivo[])
{
    char *texto[MAX_CARACTERES_NOME], nome_alimento[MAX_CARACTERES_NOME], *linha_texto_auxiliar;
    short iteracao = 0;
    int calorias_alimento;

    FILE *arquivo_alimentos_ingeridos, *arquivo_saida;

    // abertura dos arquivos de alimentos ingeridos e arquivo de saida

    arquivo_alimentos_ingeridos = fopen(nome_arquivo_ingerido, "r");
    arquivo_saida = fopen(nome_arquivo_saida, "w");

    escreve_arquivo_saida(raiz, arquivo_saida, 1, nome_arquivo);

    // repeticao até chegar fimfinal do aqruivo e a quebra de texto
    while (EOF != fscanf(arquivo_alimentos_ingeridos, "%[^\n]\n", texto))
    {

        linha_texto_auxiliar = strtok(texto, ";"); // divide a linha em dois campos, sendo nome e caloria

        while (linha_texto_auxiliar != NULL)
        {
            // se igual 0 lemos faz a leitura do nome
            if (iteracao == 0)
            {
                strcpy(nome_alimento, linha_texto_auxiliar);
                iteracao = 1;
            }
            // caso contrario lemos a caloria
            else
            {
                calorias_alimento = atoi(linha_texto_auxiliar);
                iteracao = 0;

                // filtramos o alimento na arvore para pegarmos os dados dele
                if (!(busca_abp(raiz, nome_alimento, calorias_alimento, arquivo_saida)))
                {
                    printf("alimento %s nao foi encontrado\n", nome_alimento);
                }
            }
            linha_texto_auxiliar = strtok(NULL, ";");
        }
    }

    escreve_arquivo_saida(raiz, arquivo_saida, 2, nome_arquivo);

    fclose(arquivo_alimentos_ingeridos);
    fclose(arquivo_saida);
}
