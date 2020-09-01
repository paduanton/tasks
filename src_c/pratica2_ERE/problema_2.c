#include <stdio.h>
#include <math.h>

int main() {
    float raio, lado, perimetro, area;

    printf("Entre com o raio de um círculo: ");
    scanf("%f", &raio);

    lado = sqrt(2) * raio;

    perimetro = 4 * lado;
    area = pow(lado, 2);

    printf("\nPerímetro do maior quadrado: %f", perimetro);
    printf("\nÁrea do maior quadrado: %f", area);

    return 0;
}
