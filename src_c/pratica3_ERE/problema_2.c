#include <stdio.h>
#include <math.h>

int main() {
    float valorCobranca, tempoPermanenciaMinutos, tempoPermanenciaHoras;

    printf("Entre o tempo de permanencia em minutos: ");
    scanf("%f", &tempoPermanenciaMinutos);

    tempoPermanenciaHoras = tempoPermanenciaMinutos / 60;

    if(tempoPermanenciaHoras == 1) {
        valorCobranca = 15;
    } else if (tempoPermanenciaHoras > 8) {
        valorCobranca = 32;
    } else {
        valorCobranca = 15 + (2 * tempoPermanenciaHoras);
    }

    printf("O valor a ser pago eh de R$%f", valorCobranca);

    return 0;
}
