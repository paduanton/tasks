#include <stdio.h>
#include <string.h>
#define QUANTIDADE_RETANGULOS_SOBREPOSTOS 20
#define QUANTIDADE_DADOS_RETANGULOS_SOBREPOSTOS 4

int colisao_de_retangulos(double retangulo1X, double retangulo1Y, double retangulo1Altura, double retangulo1Largura,
                          double retangulo2X, double retangulo2Y, double retangulo2Altura, double retangulo2Largura);
int main()
{
  // dividindo as declaracoes dos ints em várias linhas para facilitar a leitura
  double retangulosSobrepostos[QUANTIDADE_RETANGULOS_SOBREPOSTOS][QUANTIDADE_DADOS_RETANGULOS_SOBREPOSTOS];
  double retanguloReferenciaX, retanguloReferenciaY, retanguloReferenciaAltura, retanguloReferenciaLargura;
  double retanguloAtualX, retanguloAtualY, retanguloAtualAltura, retanguloAtualLargura;
  int quantidadeRetangulosComparacao, i, j, quantidadeSobreposicoes = 0;

  printf("Digite o X do retangulo de referencia: ");
  scanf("%lf", &retanguloReferenciaX);
  printf("Digite o Y do retangulo de referencia: ");
  scanf("%lf", &retanguloReferenciaY);
  printf("Digite a largura do retangulo de referencia: ");
  scanf("%lf", &retanguloReferenciaLargura);
  printf("Digite a altura do retangulo de referencia: ");
  scanf("%lf", &retanguloReferenciaAltura);

  printf("\nDigite a quantidade de retangulos que quer comparar: ");
  scanf("%d", &quantidadeRetangulosComparacao);
  printf("\n");

  for (i = 0; i < quantidadeRetangulosComparacao; i++)
  {

    printf("Digite o X do retangulo #%d: ", i + 1);
    scanf("%lf", &retanguloAtualX);
    printf("Digite o Y do retangulo #%d: ", i + 1);
    scanf("%lf", &retanguloAtualY);
    printf("Digite a largura do retangulo #%d: ", i + 1);
    scanf("%lf", &retanguloAtualLargura);
    printf("Digite a altura do retangulo #%d: ", i + 1);
    scanf("%lf", &retanguloAtualAltura);
    printf("\n");

    
    if (
        colisao_de_retangulos(retanguloReferenciaX, retanguloReferenciaY, retanguloReferenciaAltura, retanguloReferenciaLargura,
                              retanguloAtualX, retanguloAtualY, retanguloAtualAltura, retanguloAtualLargura) == 1)
    {
      quantidadeSobreposicoes++;

      retangulosSobrepostos[i][0] = retanguloAtualX;
      retangulosSobrepostos[i][1] = retanguloAtualY;
      retangulosSobrepostos[i][2] = retanguloAtualLargura;
      retangulosSobrepostos[i][3] = retanguloAtualAltura;
    }
  }

  printf("Sobreposicoes:\n");

  for (i = 0; i < quantidadeSobreposicoes; i++)
  {

    printf("(x=%.1lf, y=%.1lf, dx=%.1lf,dy=%.1lf) \n", retangulosSobrepostos[i][0], retangulosSobrepostos[i][1], retangulosSobrepostos[i][2], retangulosSobrepostos[i][3]);
  }

  printf("\nTotal %d", quantidadeSobreposicoes);
  printf("\n");

  return 0;
}

int colisao_de_retangulos(double retangulo1X, double retangulo1Y, double retangulo1Altura, double retangulo1Largura,
                          double retangulo2X, double retangulo2Y, double retangulo2Altura, double retangulo2Largura)
{

  if ((retangulo1X + retangulo1Largura > retangulo2X) &&
      (retangulo1X < retangulo2X) &&
      (retangulo1Y + retangulo1Altura > retangulo2Y) &&
      (retangulo1Y < retangulo2Y))
  {
    return 1;
  }

  return 0;
}