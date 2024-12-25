package ifsul.sequencial;
import java.util.Scanner;
public class Q11 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		        
		        double x1;
		        double x2;
		        double x3;
		        double x4;
		        double x5;
		        double x6;
		        
		        System.out.println(" INSIRA SOMENTE VALORES DECIMAIS OU INTEIROS ");
		        System.out.println(" DIGITE O PRIMEIRO VALOR ");
		        x1 = teclado.nextDouble();
		        System.out.println(" DIGITE O SEGUNDO VALOR ");
		        x2 = teclado.nextDouble();
		        System.out.println(" DIGITE O TERCEIRO VALOR ");
		        x3 = teclado.nextDouble();
		        System.out.println(" DIGITE O QUARTO VALOR ");
		        x4 = teclado.nextDouble();
		        System.out.println(" DIGITE O QUINTO VALOR ");
		        x5 = teclado.nextDouble();
		        System.out.println(" DIGITE O �LTIMO VALOR ");
		        x6 = teclado.nextDouble();
		        
		        double soma = x1 + x2 + x3 + x4 + x5 + x6;
		        double subtracao = x1 - x2 - x3 - x4 - x5 - x6;
		        
		        System.out.println(" SOMA DE TODOS OS VALORES: " + soma);
		        System.out.println(" SUBTRA��O DE TODOS OS VALORES " + subtracao);
	}

}
