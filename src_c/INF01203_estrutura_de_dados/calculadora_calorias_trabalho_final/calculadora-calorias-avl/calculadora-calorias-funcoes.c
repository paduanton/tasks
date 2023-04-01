#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "calculadora-calorias-headers.h"

#define MAX_CARACTERES_NOME 40

NodoAVL *inicializa_nodo(Alimento a)
{
  NodoAVL *novo = malloc(sizeof(NodoAVL));

  if (novo)
  {
    novo->alimento = a;
    novo->esq = NULL;
    novo->dir = NULL;
    novo->altura = 0;
  }
  else
  {
    printf("\nnao foi possivel criar novo nodo \n");
  }
  return novo;
}

// retorna o maior nodo
int calcula_maior_nodo(int no1, int no2)
{
  return (no1 > no2) ? no1 : no2; // operador ternario
}

// calcula a altura do nodo (necessario para tomar o fator_balanceamento do nodo)
int calcula_altura_nodo(NodoAVL *nodo)
{
  if (nodo == NULL)
  {
    return -1;
  }
  else
  {
    return nodo->altura;
  }
}

int calcula_altura_avl(NodoAVL *raiz_arvore)
{

  // calculamos recursivamente pros nos da esquerda e direita
  if (raiz_arvore == NULL)
  {
    return -1;
  }
  else
  {
    int esq = calcula_altura_avl(raiz_arvore->esq);
    int dir = calcula_altura_avl(raiz_arvore->dir);

    // se altura da esquerda > direita, entao somamos 1 a arvore da esquerda
    if (esq > dir)
    {
      return esq + 1;
    }

    // caso contrario somamos 1 a direita
    return dir + 1;
  }
}

// calcula a quantidade de nos
int quantidade_nodos(NodoAVL *raiz_arvore)
{
  if (raiz_arvore == NULL)
    return 0;
  else
    return 1 + quantidade_nodos(raiz_arvore->esq) + quantidade_nodos(raiz_arvore->dir);
}

// calcula a quantidade de nos folhas
int quantidade_folhas_arvore(NodoAVL *raiz_arvore)
{
  // arvore vazia, entao retorna 0
  if (raiz_arvore == NULL)
  {
    return 0;
    // raiz sem filhos entao retorna 1
  }
  else if (raiz_arvore->esq == NULL && raiz_arvore->dir == NULL)
  {
    return 1;
  }

  // caso contrario aplicamos recursivamente para esq e direita
  return quantidade_folhas_arvore(raiz_arvore->esq) + quantidade_folhas_arvore(raiz_arvore->dir);
}

int fator_balanceamento(NodoAVL *nodo)
{
  if (nodo)
  {
    return (calcula_altura_nodo(nodo->esq) - calcula_altura_nodo(nodo->dir));
  }

  return 0;
}


NodoAVL *balanceamento_arvore(NodoAVL *raiz_arvore)
{
  int fator_de_balanceamento = fator_balanceamento(raiz_arvore);

  // verificamos todas condicoes possiveis do fator de balanceamentos para efetuar as rotacoes necessarias

  if (fator_de_balanceamento < -1 && fator_balanceamento(raiz_arvore->dir) <= 0)
  {
    raiz_arvore = rotacao_esquerda(raiz_arvore, 0);
  }
  else if (fator_de_balanceamento > 1 && fator_balanceamento(raiz_arvore->esq) >= 0)
  {
    raiz_arvore = rotacao_direita(raiz_arvore, 0);
  }
  else if (fator_de_balanceamento > 1 && fator_balanceamento(raiz_arvore->esq) < 0)
  {
    raiz_arvore = rotacao_esquerda_e_direita(raiz_arvore);
  }
  else if (fator_de_balanceamento < -1 && fator_balanceamento(raiz_arvore->dir) > 0)
  {
    raiz_arvore = rotacao_direita_e_esquerda(raiz_arvore);
  }

  return raiz_arvore;
}

NodoAVL *inserir_nodo_ordem_alfabetica(NodoAVL *raiz_arvore, Alimento a)
{
  if (raiz_arvore == NULL)
  {
    return inicializa_nodo(a);
  }
  else
  {
    // se a raiz nao for nula, fazemos as comparacoes para inserir em ordem alfabetica recursivamente

    if (strcmp(a.nome, raiz_arvore->alimento.nome) < 0)
    {
      raiz_arvore->esq = inserir_nodo_ordem_alfabetica(raiz_arvore->esq, a);
    }
    else if (strcmp(a.nome, raiz_arvore->alimento.nome) > 0)
    {
      raiz_arvore->dir = inserir_nodo_ordem_alfabetica(raiz_arvore->dir, a);
    }
  }

  raiz_arvore->altura = calcula_maior_nodo(calcula_altura_nodo(raiz_arvore->esq), calcula_altura_nodo(raiz_arvore->dir)) + 1;

  // apos a recursao balanceamos a arvore
  raiz_arvore = balanceamento_arvore(raiz_arvore);

  return raiz_arvore;
}

// funcao que retorna uma estrutura basica de alimento
Alimento ler_alimento(char *nome_alimento, int calorias_alimento)
{
  Alimento alimento;

  alimento.caloria = calorias_alimento;
  strcpy(alimento.nome, nome_alimento);

  return alimento;
}

NodoAVL *ler_arquivo_tabela_calorias(NodoAVL *raiz_arvore, char nome_arquivo[])
{
  char *conteudo_arquivo[MAX_CARACTERES_NOME], nome_alimento[MAX_CARACTERES_NOME], *linha_texto_auxiliar;
  int tipo_leitura = 0, caloria;

  FILE *arquivo_tabela_calorias;

  // abertura do arquivo de calorias
  arquivo_tabela_calorias = fopen(nome_arquivo, "r");

  // repeticao até chegar no fim do arquivo e a quebra de conteudo_arquivo
  while (EOF != fscanf(arquivo_tabela_calorias, "%[^\n]\n", conteudo_arquivo))
  {

    linha_texto_auxiliar = strtok(conteudo_arquivo, ";");

    while (linha_texto_auxiliar != NULL)
    {
      // se igual zero, faz a leitura do alimento, caso contrario faz a leitura da caloria e insere na arvore
      if (tipo_leitura == 0)
      {
        tipo_leitura = 1;
        strcpy(nome_alimento, linha_texto_auxiliar);
      }
      else
      {
        caloria = atoi(linha_texto_auxiliar);
        raiz_arvore = inserir_nodo_ordem_alfabetica(raiz_arvore, ler_alimento(nome_alimento, caloria));
        tipo_leitura = 0;
      }
      linha_texto_auxiliar = strtok(NULL, ";");
    }
  }

  fclose(arquivo_tabela_calorias);

  return raiz_arvore;
}

void ler_arquivo_alimentos_ingeridos(NodoAVL *raiz_arvore, char nome_arquivo_alimentos_ingeridos[], char nome_arquivo_saida[], char nome_arquivo[])
{
  char *conteudo_arquivo[MAX_CARACTERES_NOME], nome_alimento[MAX_CARACTERES_NOME], *linha_texto_auxiliar;
  short tipo_leitura = 0;
  int calorias_alimento;

  FILE *arquivo_alimentos_ingeridos, *arquivo_saida;

  // abertura dos arquivos de alimentos ingeridos e arquivo de saida

  arquivo_alimentos_ingeridos = fopen(nome_arquivo_alimentos_ingeridos, "r");
  arquivo_saida = fopen(nome_arquivo_saida, "w");

  escreve_arquivo_saida(raiz_arvore, arquivo_saida, 1, nome_arquivo);

  // repeticao até chegar no fim do arquivo e a quebra de conteudo_arquivo
  while (EOF != fscanf(arquivo_alimentos_ingeridos, "%[^\n]\n", conteudo_arquivo))
  {
    linha_texto_auxiliar = strtok(conteudo_arquivo, ";"); // divide a linha em dois campos, sendo nome e caloria

    while (linha_texto_auxiliar != NULL)
    {
      // se igual 0 lemos faz a leitura do nome
      if (tipo_leitura == 0)
      {
        strcpy(nome_alimento, linha_texto_auxiliar);
        tipo_leitura = 1;
      }
      else
      {
        // caso contrario lemos a caloria
        tipo_leitura = 0;
        calorias_alimento = atoi(linha_texto_auxiliar);

        // filtramos o alimento na arvore para pegarmos os dados dele
        if (!(busca_avl(raiz_arvore, nome_alimento, calorias_alimento, arquivo_saida)))
        {
          printf("alimento %s nao foi encontrado\n", nome_alimento);
        }
      }
      linha_texto_auxiliar = strtok(NULL, ";");
    }
  }

  escreve_arquivo_saida(raiz_arvore, arquivo_saida, 2, nome_arquivo); // funcao com parametro 2 para escrever as estatisticas nodo arquivo de saida

  fclose(arquivo_alimentos_ingeridos);
  fclose(arquivo_saida);
}
