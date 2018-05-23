package br.edu.ifsul.sapucaia.CalculadoraGeometrica;


public class Retangulo {
    public double base;
    public double altura;

    public double calcularArea() {
        return this.base * this.altura;
    }

    public double calcularPermimetro() {
        return 2 * (this.base + this.altura);
    }

    public double calcularDiagonal() {
        return Math.sqrt(Math.pow(this.base, 2) + Math.pow(this.altura, 2));
    }
}
