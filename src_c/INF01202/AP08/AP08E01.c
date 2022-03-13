#include <stdlib.h>

#include <stdio.h>

#include <conio2.h>

#include <windows.h>

#include <time.h>

#define ESPECIAL - 32
#define SETA_ESQUERDA 75
#define SETA_DIREITA 77
#define SETA_CIMA 72
#define SETA_BAIXO 80
#define ESPACO 32
#define ENTER 13
#define ESC 27
#define MAXIMO_X 80
#define MAXIMO_Y 25
#define MAXIMO_COR 15

int main(void) {

  int x, y, i, j, tecla, posicaoX = rand() % 80, posicaoY = rand() % 25, matriz[MAXIMO_Y][MAXIMO_X];
  srand(time(NULL));

  for (i = 0; i < MAXIMO_Y; i++) {
    for (j = 0; j < MAXIMO_X; j++) {
      matriz[i][j] = WHITE;
    }
  }

  for (x = 0; x < MAXIMO_X; x++) {
    for (y = 0; y < MAXIMO_Y; y++) {
      textbackground(matriz[y][x]);
      gotoxy(x + 1, y + 1);
      cprintf(" ");
    }
  }

  textcolor(RED);
  gotoxy(posicaoX, posicaoY);
  printf("A");

  do {
    fflush(stdin);

    if (kbhit()) {
      tecla = getch();

      if (tecla == ESC) {
        printf("\nENCERRANDO O PROGRAMA\n\n");
      } else {
        tecla = getch();

        switch (tecla) {
        case SETA_CIMA:
          gotoxy(posicaoX, posicaoY);
          printf(" ");

          posicaoY--;

          gotoxy(posicaoX, posicaoY);
          printf("A");
          break;
        case SETA_DIREITA:
          gotoxy(posicaoX, posicaoY);
          printf(" ");

          posicaoX++;

          gotoxy(posicaoX, posicaoY);
          printf("A");
          break;

        case SETA_ESQUERDA:
          gotoxy(posicaoX, posicaoY);
          printf(" ");

          posicaoX--;

          gotoxy(posicaoX, posicaoY);
          printf("A");
          break;
        case SETA_BAIXO:
          gotoxy(posicaoX, posicaoY);
          printf(" ");

          posicaoY++;

          gotoxy(posicaoX, posicaoY);
          printf("A");
          break;
        default:
          printf("");
        }
      }
    }
  } while (tecla != ESC);

  return 0;
}