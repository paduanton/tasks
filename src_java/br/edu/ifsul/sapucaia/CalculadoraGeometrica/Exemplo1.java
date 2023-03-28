package br.edu.ifsul.sapucaia.CalculadoraGeometrica;

import java.util.Scanner;

public class Exemplo1 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Retangulo retangulo = new Retangulo();

        System.out.print("Insira o valor da base: ");
        retangulo.base = teclado.nextDouble();
        System.out.print("Insira o valor da altura: ");
        retangulo.altura = teclado.nextDouble();

        System.out.println("A area desse retangulo e: " + retangulo.calcularArea());
        System.out.println("O perimetro desse retangulo e: " + retangulo.calcularPermimetro());
        System.out.println("A diagonal desse retangulo e: " + retangulo.calcularDiagonal());
    }
}
