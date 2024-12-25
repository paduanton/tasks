package ifsul.sequencial;
import java.util.Scanner;
public class Q6 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		        int x1;
		        int x2;
		        int x3;
		        
		        System.out.println(" DIGITE UM VALOR ");
		        x1 = teclado.nextInt();
		        System.out.println(" DIGITE OUTRO VALOR ");
		        x2 = teclado.nextInt();
		        System.out.println(" DIGITE MAIS UM VALOR ");
		        x3 = teclado.nextInt();
		        
		        int soma = x1 + x2;
		        int subtracao = x2 - x3;
		        int produto = x1 * x2 * x3;
		        
		        System.out.println(" A SOMA DOS DOIS PRIMEIROS: " + soma);
		        System.out.println(" A SUBTRA��O DOS DOIS �LTIMOS: " + subtracao);
		        System.out.println(" O PRODUTO DOS TR�S: " + produto);
		        
	}

}
