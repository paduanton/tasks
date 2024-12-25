package ifsul.repeticao;
import java.util.Scanner;
public class Q45 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Informe um valor: ");
		long num = teclado.nextLong();
		
		for(long h = 1; h <= num; h++) {
			System.out.print(num+" ");
		}
	}
}