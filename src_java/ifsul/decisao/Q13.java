package ifsul.decisao;
import java.util.Scanner;
public class Q13 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		int x, x2;
		System.out.println("DIGITE UM N�MERO INTEIRO");
		x = teclado.nextInt();
		System.out.println("DIGITE O SEGUNDO N�MERO INTEIRO");
		x2 = teclado.nextInt();
		
		if (x == x2) {
			System.out.println("O PRIMEIRO E SEGUNDO VALOR S�O IGUAIS.");
			
		} else {
			System.out.println("O PRIMEIRO E SEGUNDO VALOR S�O DIFERENTES.");
		}
		
	}
	
}