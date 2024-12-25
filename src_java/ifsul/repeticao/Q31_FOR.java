package ifsul.repeticao;
import java.util.Scanner;
public class Q31_FOR {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

		for(byte h = 1; h < 6; h++) {
			System.out.println("\nTabuada do "+h+"\n");
			for(byte y = 1; y < 11; y++) {
				System.out.println(h+" x "+y+" = "+h*y);
			}
		}
	}
}