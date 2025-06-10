/*
Ler as coordenadas de dois pontos no plano cartesiano e imprimir a distância entre estes dois
pontos.
*/

#include <math.h>
#include <stdio.h>

int main(void)
{

    float x1, y1, x2, y2, distancia, primeiraPotencia, segundaPotencia;

    printf("Coordenadas primeiro ponto (x1, y1):\n");
    scanf("%f", &x1);
    scanf("%f", &y1);

    printf("Coordenadas segundo ponto (x2, y2):\n");
    scanf("%f", &x1);
    scanf("%f", &y1);

    primeiraPotencia = pow((x2-x1), 2);
    segundaPotencia = pow((y2-y1), 2);

    distancia = sqrt ((primeiraPotencia + segundaPotencia));

    printf("\nDistância entre pontos: %f", distancia);

     return 0;
}
