package br.edu.ifsul.sapucaia.sequencial;
import java.util.Scanner;
public class Q33 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		double x1, y1, x2, y2, d;
		
		System.out.println("Digite dois pontos qualquer do plano P(x1, y1) e Q(x2, y2) para ser mostrado a dist�ncia entre eles.");
		System.out.println("\n" + "Digite um valor para x1");
		x1= teclado.nextDouble();
		System.out.println("Digite um valor para y1");
		y1 = teclado.nextDouble();
		System.out.println("Digite um valor para x2");
		x2 = teclado.nextDouble();
		System.out.println("Digite um valor para y2");
		y2 = teclado.nextDouble();
		
        d = Math.sqrt(Math.pow(x2 - x1,2)- Math.pow(y2 - y1,2)); 
		
		System.out.println("A dist�ncia entre eles � " + d);
		
	}
}