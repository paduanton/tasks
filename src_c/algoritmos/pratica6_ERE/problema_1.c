#include <stdio.h>
#include <ctype.h>

int main()
{
    int countMinusculos = 0, countMaisculos = 0, count = 0;
    char letra;

    do
    {
        count++;

        printf("Entre com o %do caractere: ", count);
        scanf(" %c", &letra);

        if (isalpha(letra) && toupper(letra) == letra)
        {
            countMaisculos++;
        }
        else if (isalpha(letra) && tolower(letra) == letra)
        {
            countMinusculos++;
        }

    } while (letra != '!');

    printf("Voce digitou %d caracteres em minusculo e %d em maiúsculo", countMinusculos, countMaisculos);

    return 0;
}
