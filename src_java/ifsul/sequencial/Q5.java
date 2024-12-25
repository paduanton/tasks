package ifsul.sequencial;
import java.util.Scanner;
public class Q5 {
	public static void main(String[] args)  {
		Scanner teclado = new Scanner(System.in);
		        int x1;
		        int x2;
		        int x3;
		        
		        System.out.println(" DIGITE UM VALOR INTEIRO ");
		        x1 = teclado.nextInt();
		        System.out.println(" DIGITE O SEGUNDO VALOR ");
		        x2 = teclado.nextInt();
		        System.out.println(" DIGITE O TERCEIRO VALOR ");
		        x3 = teclado.nextInt();

                int soma = x1 + x2 + x3;
                int produto = x1 * x2 * x3;
                
                System.out.println(" O PRIMEIRO VALOR DIGITADO FOI: " + x1);
                System.out.println(" O SEGUNDO VALOR DIGITADO FOI: " + x2);
                System.out.println(" O TERCEIRO VALOR DIGITADO FOI: " + x3);
                System.out.println(" A SOMA DOS VALORES �: " + soma);
                System.out.println(" O PRODUTO DOS VALORES �: " + produto);
                
	}

}
