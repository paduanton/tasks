package br.edu.ifsul.sapucaia.sequencial;
import java.util.Scanner;
public class Q9 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		        System.out.println(" DIGITE UM VALOR ");
		        double x1 = teclado.nextDouble();
		        System.out.println(" DIGITE OUTRO VALOR ");
		        double x2 = teclado.nextDouble();
		        System.out.println(" SOMA ");
		        
		        double soma = x1 + x2;
		        
		        System.out.println(" A SOMA DOS VALORES � " +  soma);
	}

}
