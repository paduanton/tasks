#include <stdio.h>
#include <math.h>

int main() {
    int dias;
    float montante, percentual, quantiaInicial;

    printf("Entre com a quantia inicial: ");
    scanf("%f", &quantiaInicial);

    printf("\nEntre com o percentual: ");
    scanf("%f", &percentual);

    printf("\nEntre com o número de dias: ");
    scanf("%i", &dias);

    montante = quantiaInicial * pow((1 + percentual / 100), dias / 30);

    printf("\nMontante final: %.2f", montante);

    return 0;
}
