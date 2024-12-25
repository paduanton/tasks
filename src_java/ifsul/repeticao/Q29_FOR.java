package ifsul.repeticao;
import java.util.Scanner;
public class Q29_FOR {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Digite um n�mero para ver a tabuada: ");
		long num = teclado.nextLong();
		
		for(short h = 1; h < 11; h++) {
			System.out.println(num+" x "+h+" = "+num*h);
		}
	}
}