package ifsul.decisao;
import java.util.Scanner;
public class Q4_5 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

		System.out.print("DIGITE UM N�MERO INTEIRO: ");
		int x = teclado.nextInt();
		
		if(x > 20) {
			System.out.println(x + " � maior que 20");
		} else if(x < 20) {
			System.out.println(x + " � menor que 20");		
	    } else {
	    	System.out.println("O n�mero digitado � 20");
		  }
		
	}
}