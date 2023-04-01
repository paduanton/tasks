#include <stdio.h>

int main()
{
	int quantidadeCelulares, quantidadeWebcams;
	float pesoWebcam = 125, pesoCelular = 290, pesoEmbalagemCelular, pesoEmbalagemWebcam, cargaTotal, cargaCelular, cargaWebcam; // unidade de peso usado é gramas

	printf("Digite o numero de celulares: ");
	scanf("%d", &quantidadeCelulares);
	printf("Digite o peso da embalagem de cada celular: ");
	scanf("%f", &pesoEmbalagemCelular);

	printf("Digite o numero de webcams: ");
	scanf("%d", &quantidadeWebcams);
	printf("Digite o peso da embalagem de cada webcam: ");
	scanf("%f", &pesoEmbalagemWebcam);

	cargaCelular = quantidadeCelulares * pesoEmbalagemCelular + (quantidadeCelulares * pesoCelular);
	cargaWebcam = quantidadeWebcams * pesoEmbalagemWebcam + (quantidadeWebcams * pesoWebcam);
	cargaTotal = cargaCelular + cargaWebcam;

	printf("O peso total da carga e: %f gramas", cargaTotal);

	return 0;
}