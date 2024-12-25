package ifsul.repeticao;
import java.util.Scanner;
public class Q46 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		while(666 > 000) {
			System.out.print("Informe um valor: ");
			long num = teclado.nextLong();
			
			for(long h = 1; h <= num; h++) {
				System.out.print(num+" ");
			}
			System.out.print("\nDeseja digitar outro valor (1.Sim 2.N�o)? ");
			num = teclado.nextLong();
			
			if(num == 1) {
				// repete
			} else if(num == 2) {
				System.exit(666);
			  }
		}
	}
}