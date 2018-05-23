package br.edu.ifsul.sapucaia.sequencial;
import java.util.Scanner;
public class Q21 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		double perimetro, lado, area;
		
		System.out.println("Qual o valor do lado do quadrado?");
		lado = teclado.nextDouble();
		
		perimetro = 4 * lado; area = Math.pow(lado,2);
		
		System.out.println("A �rea do do quadrado � " + area + "\n" + "O perimetro do quadrado � " + perimetro);
		
	}
	

}
