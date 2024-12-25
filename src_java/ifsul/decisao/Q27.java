package ifsul.decisao;
import java.util.Scanner;
public class Q27 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

		System.out.print("Digite um n�mero: ");
		long num = teclado.nextInt();
		
		if(num % 5 == 0 && num % 10 == 0 && num % 2 == 0) {
			System.out.print("\nEste n�mero � divis�vel por 2, 5 e 10.");
		} else {
			if(num % 5 == 0) {
				System.out.print("\nEste n�mero � divis�vel por 5.");
			} else if (num % 2 == 0) {
				System.out.print("\nEste n�mero � divis�vel por 2.");
			} else if(num % 5 == 0 && num % 10 == 0) {
				System.out.print("\nEste n�mero � divis�vel por 10 e 5.");
			} else if(num % 2 == 0 && num % 10 == 0) {
				System.out.print("\nEste n�mero � divis�vel por 2 e 10.");
			} else {
				System.out.print("\nEste n�mero n�o � divis�vel por 2, 5 e 10.");
			  }
		  }
	}
}