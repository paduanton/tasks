package ifsul.repeticao;
import java.util.Scanner;
public class Q30_WHILE {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		short h = 1;
		
		System.out.print("Digite um n�mero para ver a tabuada: ");
		long num = teclado.nextLong();
		
		while(h <= 10) {
			System.out.println(num+" x "+h+" = "+num*h);
			h++;
		}
	}
}