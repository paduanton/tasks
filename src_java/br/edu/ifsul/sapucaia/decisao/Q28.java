package br.edu.ifsul.sapucaia.decisao;
import java.util.Scanner;
public class Q28 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		double x, x2;
		System.out.println("DIGITE A LARGURA DE UMA FIGURA GEOM�TRICA");
		x = teclado.nextDouble();
		System.out.println("DIGITE O COMPRIMENTO DE UMA FIGURA GEOM�TRICA");
		x2 = teclado.nextDouble();
		
		if (x == x2) {
			System.out.println("Segundo os dados que voc� passou, essa figura geom�trica � um quadrado");
			
		} else {
			System.out.println("Segundo os dados que voc� passou, essa figura geom�trica � um ret�ngulo.");
		}
	}
	
}