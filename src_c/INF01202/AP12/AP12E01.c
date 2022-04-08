#include <stdio.h>
#include <string.h>

#define INICIAIS_JOGADOR_MAX 3
#define CODIGO_ACAO_LEITURA 'L'
#define CODIGO_ACAO_ESCRITA 'E'
#define QUANTIDADE_JOGADORES 10

typedef struct
{
  int pontuacaoFinal;
  char iniciais[INICIAIS_JOGADOR_MAX];
} jogador_pontos;

void le_dados(jogador_pontos *jogadores)
{
  int i;
  char teste[31];

  for (i = 0; i < QUANTIDADE_JOGADORES; i++)
  {
    printf("Informe as iniciais de 3 digitos do jogador #%d: ", i + 1);
    scanf("%s", jogadores[i].iniciais);

    printf("Informe a pontuacao final do jogador #%d: ", i + 1);
    scanf("%d", &jogadores[i].pontuacaoFinal);

    printf("\n");
  }
}

void escreve_arquivo(jogador_pontos *jogadores)
{
  int i;
  FILE *arquivoJogadores;

  arquivoJogadores = fopen("jogadores_pontos.bin", "wt");

  if (!arquivoJogadores)
  {
    printf("Erro na abertura do arquivo.");
  }
  else
  {
    for (i = 0; i < QUANTIDADE_JOGADORES; i++)
    {
      if (fwrite(&jogadores[i], sizeof(jogador_pontos), 1, arquivoJogadores) != 1)
      {
        printf("Erro de escrita\n");
      }
    }

    fclose(arquivoJogadores);
  }
}

void le_arquivo(jogador_pontos *jogadores)
{
  FILE *arquivoJogadores;
  int i;

  arquivoJogadores = fopen("jogadores_pontos.bin", "r");

  if (!arquivoJogadores)
  {
    printf("Erro na abertura do arquivo.");
  }
  else
  {
    for (i = 0; i < QUANTIDADE_JOGADORES; i++)
    {
      if (fread(&jogadores[i], sizeof(jogador_pontos), 1, arquivoJogadores) != 1)
      {
        printf("Erro de leitura\n");
      }
    }

    fclose(arquivoJogadores);
  }
}

int main()
{
  jogador_pontos jogadores[QUANTIDADE_JOGADORES];
  int i;
  char codigoAcao;

  printf("Informe o codigo da sua acao (E ou L): ");
  scanf(" %c", &codigoAcao);

  printf("\n");

  if (codigoAcao == CODIGO_ACAO_LEITURA)
  {
    printf("Lendo os dados do arquivo 'jogadores_pontos.bin'");

    le_arquivo(jogadores);

    printf("%*s%*s\n", -20, "JOGADOR", -20, "PONTOS");

    for (i = 0; i < QUANTIDADE_JOGADORES; i++)
    {
      printf("%*s%*d\n", -20, jogadores[i].iniciais, -20, jogadores[i].pontuacaoFinal);
    }

    printf("\n");
  }
  else if (codigoAcao == CODIGO_ACAO_ESCRITA)
  {
    le_dados(jogadores);
    escreve_arquivo(jogadores);

    printf("Dados salvos com sucesso no arquivo 'jogadores_pontos.bin'\n");
  }
  else
  {
    printf("Código inválido");
  }
  return 0;
}