#include <stdio.h>
int main(void)
{
    float primeiroInput, segundoInput, terceiroInput, soma, produto;

    printf("Digite primeiro número: ");
    scanf("%f", &primeiroInput);

    printf("Digite segundo número: ");
    scanf("%f", &segundoInput);

    printf("Digite terceiro número: ");
    scanf("%f", &terceiroInput);

    soma = primeiroInput + segundoInput + terceiroInput;
    produto = primeiroInput * segundoInput * terceiroInput;

    printf("\nSoma dos valores: %f", soma);
    printf("\nProduto dos valores: %f", produto);

 return 0;
}
