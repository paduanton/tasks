package br.edu.ifsul.sapucaia.decisao;
import java.util.Scanner;
public class Q12 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("DIGITE UM N�MERO");
		int x = teclado.nextInt();
		
		if (x%7 == 0 && x%3 == 0) {
			System.out.println(x + " � divis�vel por 3 e 7.");
			
		} else {
			System.out.println(x + " n�o � divis�vel por 3 e 7");
		}
		
	}
	
}