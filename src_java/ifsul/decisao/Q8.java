package ifsul.decisao;
import java.util.Scanner;
public class Q8 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		int x, x2, soma, soma1, sub;
		System.out.println("DIGITE UM N�MERO INTEIRO");
		x = teclado.nextInt();
		System.out.println("DIGITE O SEGUNDO N�MERO INTEIRO");
		x2 = teclado.nextInt();
		
		soma = x + x2;
		if (soma > 20) {
			soma1 = soma + 8;
			System.out.println("Resultado da soma: " + soma + "\n" + "Resultado da soma + 8: " + soma1);
			
		} else {
			sub = soma - 5;
			System.out.println("Resultado da soma: " + soma + "\n" + "Resultado da soma - 5: " + sub);
		}
		
	}
	
}