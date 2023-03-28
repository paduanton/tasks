package br.edu.ifsul.sapucaia.decisao;
import java.util.Scanner;
public class Q2 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		double x;
		System.out.println("DIGITE UM N�MERO");
		x = teclado.nextDouble();
		
		if (x >= 0) {
			System.out.println(x + " � positivo.");
			
		} else {
			System.out.println(x + " � negativo.");
		}
		
	}
	
}