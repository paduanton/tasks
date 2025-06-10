#include <stdio.h>
#include <string.h>
#define TAM 60

int main()
{
    char palavra[TAM + 1], palavraSemEspaco[TAM + 1];
    char vogais[] = "aeiouAEIOU";
    int countVogais = 0, i, j;

    puts("Entre com um string:");
    if (fgets(palavra, TAM, stdin) != NULL)
    {
        palavra[strlen(palavra) - 1] = '\0';
        puts(palavra);

        for (i = 0; palavra[i] != '\0'; i++)
        {

            for (j = 0; vogais[j] != '\0'; j++)
            {
                if (vogais[j] == palavra[i])
                {
                    countVogais++;
                    break;
                }
            }
        }

        int tamanho = strlen(palavra);
        for (int i = 0, posicao = 0; i < tamanho; i++, posicao++)
        {
            if (palavra[posicao] == ' ')
                posicao++;
            palavraSemEspaco[i] = palavra[posicao];
        }

        printf("String sem espaços: %s\n", palavraSemEspaco);
        printf("Nro de vogais: %d", countVogais);
    }
    else
    {
        printf("Problema com o fgets!\n");
    }
    return 0;
}