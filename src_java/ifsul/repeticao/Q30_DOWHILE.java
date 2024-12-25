package ifsul.repeticao;
import java.util.Scanner;
public class Q30_DOWHILE {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		short h = 1;
		
		System.out.print("Digite um n�mero para ver a tabuada: ");
		long num = teclado.nextLong();
		
		do {
			System.out.println(num+" x "+h+" = "+num*h);
			h++;
		} while(h <= 10);
	}
}