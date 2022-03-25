#include <stdio.h>
#define TAMANHO_MAX_VETOR 20
#define TAMANHO_MINIMO_VETOR 2

int interseccao(int *Vi, int *Vj, int *Vk, int N);

int main()
{
  int N = 1, i, tamanhoVetorInterseccao;

  while (N < TAMANHO_MINIMO_VETOR || N > TAMANHO_MAX_VETOR)
  {
    printf("Digite o tamanho dos vetores: ");
    scanf("%d", &N);

    if (N < TAMANHO_MINIMO_VETOR || N > TAMANHO_MAX_VETOR)
    {
      printf("Valor incorreto! O valor digitado deve ser entre 2 e 20\n\n");
    }
  }

  printf("\n");

  // declarando vetores fora do inicio do programa, pois nao sabemos o tamanho deles até o usuario digitar
  int Vi[N], Vj[N], Vk[N];

  for (i = 0; i < N; i++)
  {
    printf("Digite o valor #%d do primeiro vetor: ", i + 1);
    scanf("%d", Vi + i);
  }

  printf("\n");

  for (i = 0; i < N; i++)
  {
    printf("Digite o valor #%d do segundo vetor: ", i + 1);
    scanf("%d", Vj + i);
  }

  tamanhoVetorInterseccao = interseccao(Vi, Vj, Vk, N);

  printf("\n\nInterseccao: ");

  for (i = 0; i < tamanhoVetorInterseccao; i++)
  {
    printf("%d ", Vk[i]);
  }

  printf("\n");

  return 0;
}

int interseccao(int *Vi, int *Vj, int *Vk, int N)
{
  int tamanhoVetorInterseccao = 0, i, j;

  for (i = 0; i < N; i++)
  {
    for (j = 0; j < N; j++)
    {
      if (Vi[i] == Vj[j])
      {
        Vk[tamanhoVetorInterseccao] = *(Vi + i);

        tamanhoVetorInterseccao++;
      }
    }
  }

  return tamanhoVetorInterseccao;
}