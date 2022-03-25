#include <stdio.h>
#define TAMANHO_MAX_VETOR 20
#define TAMANHO_MINIMO_VETOR 1

void min_e_max(double *vetor, int tamanho, double *menor, double *maior);

int main()
{
  int i, tamanhoVetor;
  double menor, maior, vetor[TAMANHO_MAX_VETOR];

  while (tamanhoVetor < TAMANHO_MINIMO_VETOR || tamanhoVetor > TAMANHO_MAX_VETOR)
  {
    printf("Digite o tamanho do vetor: ");
    scanf("%d", &tamanhoVetor);

    if (tamanhoVetor < TAMANHO_MINIMO_VETOR || tamanhoVetor > TAMANHO_MAX_VETOR)
    {
      printf("Valor incorreto! O valor digitado deve ser entre 1 e 20\n\n");
    }
  }

  for (i = 0; i < tamanhoVetor; i++)
  {
    printf("Digite o valor #%d do vetor: ", i + 1);
    scanf("%lf", &vetor[i]);
  }

  min_e_max(vetor, tamanhoVetor, &menor, &maior);

  printf("Valor minimo: %.1lf", menor);
  printf("\nValor maximo: %.1lf\n\n", maior);

  return 0;
}

void min_e_max(double *vetor, int tamanho, double *menor, double *maior)
{
  int i;
  *menor = vetor[0];
  *maior = vetor[0];

  for (i = 0; i < tamanho; i++)
  {
    if (vetor[i] > *maior)
    {
      *maior = vetor[i];
    }

    if (vetor[i] < *menor)
    {
      *menor = vetor[i];
    }
  }
}