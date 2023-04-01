#include <stdio.h>
#include <string.h>

#define MAX_COMPRIMENTO 1000

int main()
{
    int i, tamanhoFrase;
    char frase[MAX_COMPRIMENTO + 2], caractereAuxiliar; // + 2 para o '\n' e o '\0'

    printf("Digite uma frase de ate %d de comprimento: ", MAX_COMPRIMENTO);
    fgets(frase, MAX_COMPRIMENTO + 1, stdin);

    tamanhoFrase = strlen(frase);

    // elimina o '\n' lido pelo fgets()
    frase[tamanhoFrase - 1] = '\0';

    printf("Mensagem original: %s", frase);

    // Transformar minusculas em maiusculas.
    for (i = 0; i < tamanhoFrase; i++)
    {
        if ((frase[i] >= 65 && frase[i] <= 90) | (frase[i] >= 97 && frase[i] <= 122))
        {
            frase[i] = frase[i] + 4;
        }
    }

    printf("\n1a passada: %s", frase);

    for (i = 0; i < tamanhoFrase / 2; i++)
    {
        // caractereAuxiliar eh a letra atual
        caractereAuxiliar = frase[i];
        // os caracteres sao substituidos pelas extremidades do vetor
        frase[i] = frase[(strlen(frase)) - 1 - i];
        frase[(strlen(frase)) - 1 - i] = caractereAuxiliar;
    }

    printf("\n2a passada: %s", frase);

    // rodamos somente da metade pra frente
    for (i = tamanhoFrase / 2; i < tamanhoFrase - 1; i++)
    {
        frase[i] = frase[i] - 2;
    }

    printf("\n3a passada: %s\n\n", frase);

    return 0;
}