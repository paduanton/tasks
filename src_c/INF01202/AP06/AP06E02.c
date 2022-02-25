#include <stdio.h>
#include <string.h>

#define MAX_COMPRIMENTO 20

int main() {
    int i;
    char caractere;
    char frase[MAX_COMPRIMENTO + 2];  // + 2 para o '\n' e o '\0'

    // CODIGO NA TABELA ASCII
    printf("Digite um caractere para ver o seu codigo na tabela ASCII: ");
    scanf(" %c", &caractere);

    // Limpa a entrada ate ler o '\n' que sobrou do scanf() acima
    while(getchar() != '\n');

    printf("O caractere '%c' tem o codigo %d.\n", caractere, caractere);

    // OPERACOES SOBRE CARACTERES DENTRO DE UMA STRING
    printf("Digite uma frase de ate %d de comprimento: ", MAX_COMPRIMENTO);
    fgets(frase, MAX_COMPRIMENTO + 1, stdin);

    // Elimina o '\n' lido pelo fgets()
    frase[strlen(frase) - 1] = '\0';

    printf("Frase digitada: '%s'\n", frase);

    // Transformar minusculas em maiusculas.
    for(i = 0; i < strlen(frase); i++) {
        if(frase[i] >= 97 && frase[i] <= 122) {
            frase[i] = frase[i] - 32;
        }
    }
    printf("Frase em maiusculas: '%s'\n", frase);

    return 0;
}