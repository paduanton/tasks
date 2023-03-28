package br.edu.ifsul.sapucaia.decisao;
import java.util.Scanner;
public class Q6 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		int x2, x, soma;
		System.out.println("DIGITE UM N�MERO");
		x = teclado.nextInt();
		System.out.println("DIGITE UM N�MERO");
		x2 = teclado.nextInt();
		
		soma  = x + x2;
		if (soma > 10) {
			System.out.println("Soma: " + soma);
			
		} else {
			System.out.println("Valores: " + x + " e " + x2);
		}
		
	}
	
}