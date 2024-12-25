package ifsul.decisao;
import java.util.Scanner;
public class Q14 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

		System.out.print("DIGITE UM N�MERO INTEIRO: ");
		int x = teclado.nextInt();
		System.out.print("DIGITE O SEGUNDO N�MERO INTEIRO: ");
		int x2 = teclado.nextInt();
		
		if (x == x2) {
			System.out.println("O PRIMEIRO E SEGUNDO VALOR S�O IGUAIS");
			
		} else {
			if ( x != x2) {
				if (x > x2) {
					System.out.println("O PRIMEIRO E SEGUNDO VALOR S�O DIFERENTES" + "\n" + x + " � maior que " + x2);
				} else {
					System.out.println("O PRIMEIRO E SEGUNDO VALOR S�O DIFERENTES" + "\n" + x2 + " � maior que " + x);
				}
			}
		}
		
	}
	
}