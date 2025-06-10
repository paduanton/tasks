#include <stdio.h>

#define DIMENSAO_MAPA 10

void apaga_carro(char mapa[][DIMENSAO_MAPA + 2], int linhaInicial, int colunaInicial)
{
  if (mapa[linhaInicial][colunaInicial] != '-')
  {
    mapa[linhaInicial][colunaInicial] = '-';

    /*
      os if's adicionados daqui em diante são para evitar
      acesso invalido a indices da matriz
    */
   if (linhaInicial > 0)
    {
      apaga_carro(mapa, linhaInicial - 1, colunaInicial);
    }

    if (linhaInicial < DIMENSAO_MAPA - 2)
    {
      apaga_carro(mapa, linhaInicial + 1, colunaInicial);
    }

    if (colunaInicial < DIMENSAO_MAPA - 2)
    {
      apaga_carro(mapa, linhaInicial, colunaInicial + 1);
    }

    if (colunaInicial > 0)
    {
      apaga_carro(mapa, linhaInicial, colunaInicial - 1);
    }
  }
}

int main()
{
  char mapa[DIMENSAO_MAPA][DIMENSAO_MAPA + 2], caractereAuxiliarPontoInicialMapa;
  int i, j, linhaInicial, colunaInicial;

  printf("Insira o mapa: (copie e cole a matriz aqui)\n");

  for (i = 0; i < DIMENSAO_MAPA; i++)
  {
    scanf("%s", &mapa[i][0]);
  }

  printf("\nInsira a linha inicial para apagar o carro: ");
  scanf("%d", &linhaInicial);
  printf("Insira a coluna inicial para apagar o carro: ");
  scanf("%d", &colunaInicial);

  if (linhaInicial < 0 || linhaInicial >= DIMENSAO_MAPA || colunaInicial < 0 || colunaInicial >= DIMENSAO_MAPA)
  {
    printf("\nProgramada encerrado! Linha ou coluna fora dos limites permitidos.\n");
  }
  else
  {
    /*
     salvando caractere de ponto inicial do mapa em uma variavel auxiliar
      para restaurar o mapa depois que imprimir a primeira vez
    */

    caractereAuxiliarPontoInicialMapa = mapa[linhaInicial][colunaInicial];
    mapa[linhaInicial][colunaInicial] = 'X';

    printf("\nMapa Antes\n 0123456789\n");

    for (i = 0; i < DIMENSAO_MAPA; i++)
    {
      printf("%d", i);
      printf("%s\n", &mapa[i][0]);
    }

    // restaurando mapa para sua forma inicial antes de manipula-lo
    mapa[linhaInicial][colunaInicial] = caractereAuxiliarPontoInicialMapa;

    apaga_carro(mapa, linhaInicial, colunaInicial);

    printf("\nMapa Depois\n 0123456789\n");

    for (i = 0; i < DIMENSAO_MAPA; i++)
    {
      printf("%d", i);
      printf("%s\n", &mapa[i][0]);
    }
  }

  return 0;
}