package br.edu.ifsul.sapucaia.sequencial;
import java.util.Scanner;
public class Q3 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		        System.out.println(" DIGITE UM VALOR DECIMAL OU INTEIRO ");
		        double valor1 = teclado.nextDouble();
		        System.out.println(" DIGITE UM NOVO VALOR DECIMAL OU INTEIRO ");
		        double valor2 = teclado.nextDouble();
		        
		        double soma = valor1 + valor2;
		        double produto = valor1 * valor2;
		        
		        System.out.println(" SOMA: " + soma);
		        System.out.println(" PRODUTO: " + produto);
	}
    
}
