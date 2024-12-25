package ifsul.decisao;
import java.util.Scanner;
public class Q11 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
;
		System.out.print("DIGITE UM N�MERO: ");
		int x = teclado.nextInt();
		
		if (x%5 == 0 && x%9 == 0) {
			System.out.println(x + " � divis�vel por 5 e 9");
		} else {
			if (x%5 == 0 == false && x%9 == 0 == false) {
				System.out.println(x + " n�o � divis�vel por 5 e nem 9");
			} else { 
				if (x%5 == 0 == true && x%9 == 0 == false) {
					System.out.println(x + " � divis�vel por 5 e n�o por 9");
				} else {
					System.out.println(x + " � divis�vel por 9 e n�o por 5");
				}
			}
		}
		
	}
	
}