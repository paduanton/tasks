#include <stdio.h>
#include <math.h>

int main()
{
    float comprimento, largura, metrosQuadrados, potenciaLampadas;

    printf("Entre com o comprimento do quarto: ");
    scanf("%f", &comprimento);

    printf("Entre com a largura do quarto: ");
    scanf("%f", &largura);

    printf("Entre com a potência das lampadas: ");
    scanf("%f", &potenciaLampadas);

    metrosQuadrados = comprimento * largura;

    printf("Número de lampadas: %f", 16 * metrosQuadrados / potenciaLampadas);

    return 0;
}
