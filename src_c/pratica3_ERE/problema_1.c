#include <stdio.h>
#include <math.h>

int main() {
    float peso;
    int idade;
    char fezTattoo, autorizacaoMenorIdade;

    printf("Voce fez tatuagem nos ultimos 12 meses (S/N)? ");
    scanf("%c", &fezTattoo);

    printf("Qual seu peso? ");
    scanf("%f", &peso);

    printf("Qual a sua idade? ");
    scanf("%d", &idade);

    if(idade < 18 && idade >= 16) {
        printf("Voce eh menor de idade. Tem autorizacao dos pais? ");
        scanf(" %c", &autorizacaoMenorIdade);

        if(autorizacaoMenorIdade == 'N') {
            printf("Voce NAO pode ser doador!");

            return 0;
        }
    }

    if(fezTattoo == 'S' || peso < 50 || (idade < 16 || idade > 69 )) {
        printf("Voce NAO pode ser doador!");
    } else {
        printf("Parabens! Voce pode ser doador!");
    }


    return 0;
}
