package ifsul.sequencial;
import java.util.Scanner;
public class Q2 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		        int valor1;
		        int valor2;
		        int produto;
		        System.out.println(" DIGITE UM VALOR INTEIRO ");
		        valor1 = teclado.nextInt();
		        System.out.println(" DIGITE UM NOVO VALOR INTEIRO ");
		        valor2 = teclado.nextInt();
		        produto = valor1 * valor2;
		        System.out.println(" O PRODUTO DOS VALORES: " + produto);
		        
		        		
	}
}