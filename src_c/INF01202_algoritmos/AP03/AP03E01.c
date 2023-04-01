#include <stdio.h>

int main()
{
	double a, b, c, aQuadrado, bQuadrado, cQuadrado;

	printf("Digite lado A do triangulo: ");
	scanf("%lf", &a);
	printf("Digite lado B do triangulo: ");
	scanf("%lf", &b);
	printf("Digite lado C do triangulo: ");
	scanf("%lf", &c);

	aQuadrado = a * a;
	bQuadrado = b * b;
	cQuadrado = c * c;

	if (a >= (b + c))
	{
		printf("NAO FORMA TRIANGULO");
	}
	else
	{
		if (a == b && b == c)
		{
			printf("TRIANGULO EQUILATERO\n");
		} else if (a == b || b == c || a == c)
		{
			printf("TRIANGULO ISOSCELES\n");
		}

		if (aQuadrado == (bQuadrado + cQuadrado))
		{
			printf("TRIANGULO RETANGULO");
		}
		else if (aQuadrado > (bQuadrado + cQuadrado))
		{
			printf("TRIANGULO OBTUSANGULO");
		}
		// aqui nao eh necessario if, pois se aQuadrado nao eh igual e nem maior que bQuadrado + cQuadrado, entao aqui ele eh menor
		else
		{
			printf("TRIANGULO ACUTANGULO");
		}
	}
	return 0;
}