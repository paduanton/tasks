package ifsul.repeticao;
import java.util.Scanner;
public class Q64 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Digite 10 valores: ");
		for(byte h = 1; h < 11; h++) {
			int num = teclado.nextInt();
			System.out.println("N�mero: "+num+" |  Metade: "+num / 2+" |"
					+ " Quadrado: "+num*num+" | Cubo: "+Math.pow(num, 3));
		}
	}
}