#include <stdio.h>
#include <string.h>

#define MAX_COMPRIMENTO 140
#define CODIGO_lETRAS_MAIUSCULAS 1
#define CODIGO_lETRAS_MINUSCULAS 2
#define CODIGO_ESPACO 3
#define CODIGO_NUMEROS 4
#define CODIGO_CARACTERE_ESPECIAL 5
#define CODIGO_ASC_65 65
#define CODIGO_ASC_90 90
#define CODIGO_ASC_97 97
#define CODIGO_ASC_122 122
#define CODIGO_ASC_32 32
#define CODIGO_ASC_48 48
#define CODIGO_ASC_57 57

int determina_tipo_caractere(int codigoAsc);

int main()
{
  // dividindo as declaracoes dos ints em duas linhas para facilitar a leitura
  int i, tamanhoFrase, quantidadeLetrasMinusculas = 0, quantidadeLetrasMaiusculas = 0;
  int quantidadeEspacos = 0, quantidadeNumeros = 0, quantidadeCaracteresEspeciais = 0;
  char frase[MAX_COMPRIMENTO + 2]; // + 2 para o '\n' e o '\0'

  printf("Digite uma frase de ate %d de comprimento: ", MAX_COMPRIMENTO);
  fgets(frase, MAX_COMPRIMENTO + 2, stdin);

  tamanhoFrase = strlen(frase);

  // elimina o '\n' lido pelo fgets()
  frase[tamanhoFrase - 1] = '\0';

  for (i = 0; i < tamanhoFrase; i++)
  {

    if (determina_tipo_caractere(frase[i]) == CODIGO_lETRAS_MAIUSCULAS)
    {
      quantidadeLetrasMaiusculas++;
    }
    else if (determina_tipo_caractere(frase[i]) == CODIGO_lETRAS_MINUSCULAS)
    {
      quantidadeLetrasMinusculas++;
    }
    else if (determina_tipo_caractere(frase[i]) == CODIGO_ESPACO)
    {
      quantidadeEspacos++;
    }
    else if (determina_tipo_caractere(frase[i]) == CODIGO_NUMEROS)
    {
      quantidadeNumeros++;
    }
    else if (determina_tipo_caractere(frase[i]) == CODIGO_CARACTERE_ESPECIAL)
    {
      quantidadeCaracteresEspeciais++;
    }
  }

  printf("\nEspacos: %d", quantidadeEspacos);
  printf("\nLetras minusculas: %d", quantidadeLetrasMinusculas);
  printf("\nLetras maiusculas: %d", quantidadeLetrasMaiusculas);
  printf("\nDigitos numericos: %d", quantidadeNumeros);
  printf("\nCaracteres especiais: %d\n\n", quantidadeCaracteresEspeciais - 1); // subtraindo 1 para desconsiderar o 0 colocado por default na string

  return 0;
}

int determina_tipo_caractere(int codigoAsc)
{
  int codigoTipoCaractere;

  if (codigoAsc >= CODIGO_ASC_65 && codigoAsc <= CODIGO_ASC_90)
  {
    codigoTipoCaractere = CODIGO_lETRAS_MAIUSCULAS;
  }
  else if (codigoAsc >= CODIGO_ASC_97 && codigoAsc <= CODIGO_ASC_122)
  {
    codigoTipoCaractere = CODIGO_lETRAS_MINUSCULAS;
  }
  else if (codigoAsc == CODIGO_ASC_32)
  {
    codigoTipoCaractere = CODIGO_ESPACO;
  }
  else if (codigoAsc >= CODIGO_ASC_48 && codigoAsc <= CODIGO_ASC_57)
  {
    codigoTipoCaractere = CODIGO_NUMEROS;
  }
  else
  {
    codigoTipoCaractere = CODIGO_CARACTERE_ESPECIAL;
  }

  return codigoTipoCaractere;
}