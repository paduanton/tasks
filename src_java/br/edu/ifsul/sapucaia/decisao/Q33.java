package br.edu.ifsul.sapucaia.decisao;
import java.util.Scanner;
public class Q33 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
;
		System.out.print("DIGITE UM N�MERO: ");
		int x = teclado.nextInt();
		
		if (x < 30) {
		System.out.print("\n"+x+" � maior que 30");
		} else {
			if (x == 30) {
				System.out.println("\n"+x+" � menor que 30");
			} else {
				System.out.println("\nO n�mero digitado � 30");
			}			
		  }
		
	}
	
}