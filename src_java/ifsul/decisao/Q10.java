package ifsul.decisao;
import java.util.Scanner;
public class Q10 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		int x;
		System.out.println("DIGITE UM N�MERO");
		x = teclado.nextInt();
		
		if (x%5 == 0) {
			System.out.println(x + " � divis�vel por 5");
			
		} else {
			System.out.println(x + " n�o � divis�vel por 5");
		}
		
	}
	
}