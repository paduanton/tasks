package br.edu.ifsul.sapucaia.repeticao;
import java.util.Scanner;
public class Q53 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Digite 5 n�meros: ");
		for(byte h = 0; h < 5; h++) {
			double num = teclado.nextDouble();
			System.out.println("Quadrado: "+num * num);
		}
	}
}