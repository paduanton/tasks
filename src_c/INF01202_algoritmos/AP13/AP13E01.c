#include <stdio.h>
#include <locale.h>
#include <stdlib.h>

#define TAMANHO_PADRAO_MATRIZ 6
#define TAMANHO_MAX_ARQUIVOS_TXT 21
#define TAMANHO_PADRAO_COLISAO 12
#define TAMANHO_ARQUIVO_LINHA_AUXILIAR 8

typedef struct
{
  int linha, coluna;

} Colisao;

int main()
{
  Colisao colisao[TAMANHO_PADRAO_COLISAO];

  FILE *primeiroArquivo, *segundoArquivo;

  int h = 0, i, j = 0, quantidadeColisoes = 0;

  char nomePrimeiroArquivo[TAMANHO_MAX_ARQUIVOS_TXT], nomeSegundoArquivo[TAMANHO_MAX_ARQUIVOS_TXT];
  char linhaArquivoAuxiliar[TAMANHO_ARQUIVO_LINHA_AUXILIAR];
  char matrizSegundoArquivo[TAMANHO_PADRAO_MATRIZ][TAMANHO_PADRAO_MATRIZ];
  char segundaMatrizAuxiliar[TAMANHO_PADRAO_MATRIZ][TAMANHO_PADRAO_MATRIZ];
  char matrizFinal[TAMANHO_PADRAO_MATRIZ][TAMANHO_PADRAO_MATRIZ];

  printf("Insira nome do primeiro arquivo: ");
  scanf("%s", nomePrimeiroArquivo);
  printf("Insira nome do segundo arquivo: ");
  scanf("%s", nomeSegundoArquivo);

  primeiroArquivo = fopen(nomePrimeiroArquivo, "r");
  segundoArquivo = fopen(nomeSegundoArquivo, "r");

  if (!primeiroArquivo || !segundoArquivo)
  {
    printf("\nNão foi possível ler os arquivos");
  }
  else
  {
    while (!feof(primeiroArquivo))
    {
      if (fgets(linhaArquivoAuxiliar, TAMANHO_ARQUIVO_LINHA_AUXILIAR, primeiroArquivo))
      {
        for (i = 0; i < TAMANHO_PADRAO_MATRIZ; i++)
        {
          matrizSegundoArquivo[j][i] = linhaArquivoAuxiliar[i];
        }

        j++;
      }
    }

    while (!feof(segundoArquivo))
    {
      if (fgets(linhaArquivoAuxiliar, TAMANHO_ARQUIVO_LINHA_AUXILIAR, segundoArquivo))
      {
        for (i = 0; i < TAMANHO_PADRAO_MATRIZ; i++)
        {
          segundaMatrizAuxiliar[h][i] = linhaArquivoAuxiliar[i];
        }
        h++;
      }
    }

    fclose(primeiroArquivo);
    fclose(segundoArquivo);

    for (i = 0; i < TAMANHO_PADRAO_MATRIZ; i++)
    {
      for (j = 0; j < TAMANHO_PADRAO_MATRIZ; j++)
      {
        if (matrizSegundoArquivo[i][j] == segundaMatrizAuxiliar[i][j] && matrizSegundoArquivo[i][j] == '@')
        {
          matrizFinal[i][j] = 'X';

          colisao[quantidadeColisoes].linha = i;
          colisao[quantidadeColisoes].coluna = j;

          quantidadeColisoes++;
        }
        else if (matrizSegundoArquivo[i][j] == segundaMatrizAuxiliar[i][j] && matrizSegundoArquivo[i][j] != '@')
        {
          matrizFinal[i][j] = '-';
        }
        else
        {
          matrizFinal[i][j] = '@';
        }
      }
    }

    printf("\nMatriz Colisão:\n 012345\n");

    for (i = 0; i < TAMANHO_PADRAO_MATRIZ; i++)
    {
      printf("%d", i);
      for (j = 0; j < TAMANHO_PADRAO_MATRIZ; j++)
      {
        printf("%c", matrizFinal[i][j]);
      }
      printf("\n");
    }

    printf("\nColisões\n");

    for (i = 0; i < quantidadeColisoes; i++)
    {
      printf("Linha: %d, Coluna: %d\n", colisao[i].linha, colisao[i].coluna);
    }

    printf("\n");
  }

  return 0;
}