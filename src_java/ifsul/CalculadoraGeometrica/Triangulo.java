package ifsul.CalculadoraGeometrica;


public class Triangulo {
    public double lado1;
    public double lado2;
    public double lado3;
    private final double sPerimetro = (this.lado1 + this.lado2 + this.lado3) / 2;

    public double calcularPerimetro() {
        return sPerimetro * 2;
    }

    public double calcularArea() {
        return Math.sqrt(sPerimetro * (sPerimetro - lado1) * (sPerimetro - lado2) * (sPerimetro - lado3));
    }

}
