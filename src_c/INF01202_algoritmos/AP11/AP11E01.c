#include <stdio.h>
#include <stdlib.h>
#include <windows.h>

#define INTERVALO 1000 // milissegundos
#define LINHAS_CENARIO 20 + 2 // + 2 para as bordas
#define COLUNAS_CENARIO 20 + 2 // + 2 para as bordas

typedef struct
{
  int X, Y;
} Coordenada;

typedef struct
{
  Coordenada coordenada;
  int largura, comprimento;
} Carro;

void vaiParaCoordenadasXeY(int x, int y)
{
  HANDLE auxiliarConsole = GetStdHandle(STD_OUTPUT_HANDLE);
  COORD cordenadas = {x, y};

  SetConsoleCursorPosition(auxiliarConsole, cordenadas);
}

int testa_carro(int linhasCenario, int colunasCenario, Carro carro)
{
  if ((carro.coordenada.X + carro.largura >= colunasCenario) ||
      (carro.coordenada.Y + carro.comprimento >= linhasCenario) ||
      (carro.coordenada.X < 0 || carro.coordenada.Y < 0))
  {
    return 0;
  }

  return 1;
}

void imprime_cenario(int linhasCenario, int colunasCenario, Carro carro)
{
  char simboloCenario = '^', simboloCarro = 'C';
  int i, j;

  // imprime cenario
  for (i = 0; i < colunasCenario; i++)
  {
    printf("%c ", simboloCenario);

    if (i == 0)
    {
      for (j = 0; j < linhasCenario; j++)
      {
        printf("%c\n", simboloCenario);
      }
      vaiParaCoordenadasXeY(0, 0);
    }
  }

  for (i = 0; i < linhasCenario; i++)
  {
    vaiParaCoordenadasXeY(colunasCenario * 2 - 2, i);
    printf("%c", simboloCenario);
  }

  vaiParaCoordenadasXeY(0, colunasCenario - 1);

  for (i = 0; i < colunasCenario - 1; i++)
  {
    printf("%c ", simboloCenario);
  }

  // imprime carro
  for (i = 0; i < carro.comprimento; i++)
  {
    vaiParaCoordenadasXeY(carro.coordenada.X * 2, carro.coordenada.Y + i);

    for (j = 0; j < carro.largura; j++)
    {
      printf("%c ", simboloCarro);
    }

    printf("\n");
  }
}

int main()
{

  Carro carro;

  printf("Digite a coordenada x (coluna) do carro: ");
  scanf("%d", &carro.coordenada.X);
  printf("Digite a coordenada y (linha) do carro: ");
  scanf("%d", &carro.coordenada.Y);
  printf("Digite a largura (numero de colunas) do carro: ");
  scanf("%d", &carro.largura);
  printf("Digite o comprimento (numero de linhas) do carro: ");
  scanf("%d", &carro.comprimento);

  if (testa_carro(LINHAS_CENARIO, COLUNAS_CENARIO, carro) == 0)
  {
    printf("Carro colide com a borda ou esta fora do cenario!\n");
  }
  else
  {
    while (testa_carro(LINHAS_CENARIO, COLUNAS_CENARIO, carro))
    {
      system("cls");

      imprime_cenario(LINHAS_CENARIO, COLUNAS_CENARIO, carro);

      Sleep(INTERVALO);

      carro.coordenada.Y++;
    }
  }

  return 0;
}