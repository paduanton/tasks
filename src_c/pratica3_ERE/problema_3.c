#include <stdio.h>
#include <math.h>

int main()
{
    float a, b, c, delta, raizQuadradaDelta, raiz1, raiz2;

    printf("Entre com os valores dos coeficientes: ");
    scanf("%f", &a);
    scanf("%f", &b);
    scanf("%f", &c);

    if (a == 0)
    {
        printf("Nao eh equacao do 2º grau");
    }
    else
    {
        delta = (b * b) - (4 * a * c);
        raizQuadradaDelta = sqrt(delta);

        if (delta > 0)
        {
            raiz1 = (-b + raizQuadradaDelta) / (2 * a);
            raiz2 = (-b - raizQuadradaDelta) / (2 * a);
            printf("Duas raízes reais: r1=%f  r2=%f", raiz1, raiz2);
        }
        else if (delta == 0)
        {
            printf("Raiz unica: %f", (-b + raizQuadradaDelta) / (2 * a));
        }
        else
        {
            printf("Nao existem raizes reais!");
        }
    }

    return 0;
}
