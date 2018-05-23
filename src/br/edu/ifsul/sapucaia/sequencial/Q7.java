package br.edu.ifsul.sapucaia.sequencial;
import java.util.Scanner;
public class Q7 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		        System.out.println(" DIGITE UM VALOR ");
		        double valor1 = teclado.nextDouble();
		        System.out.println(" DIGITE O SEGUNDO VALOR ");
		        double valor2 = teclado.nextDouble();
		        System.out.println(" DIGITE O TERCEIRO VALOR ");
		        double valor3 = teclado.nextDouble();
		        
		        double media = (valor1 + valor2 + valor3) / 3;
		        
		        System.out.println(" A M�DIA DOS VALORES: " + media);
	}

}
