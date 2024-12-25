package br.edu.ifsul.sapucaia.decisao;
import java.util.Scanner;
public class Q18 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

		System.out.println("DIGITE UM N�MERO");
		double x = teclado.nextDouble();
		
		if (x > 20 && x < 90) {
			System.out.println(x + " est� entre 20 e 90");
			
		} else {
			System.out.println(x + " n�o est� entre o 20 e 90");
		}
	}
	
}