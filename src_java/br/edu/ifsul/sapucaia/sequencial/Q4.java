package br.edu.ifsul.sapucaia.sequencial;
import java.util.Scanner;
public class Q4 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		        int x1;
		        int x2;
		        int x3;
		        int x4;
		        
		        System.out.println(" DIGITE UM VALOR INTEIRO ");
		        x1 = teclado.nextInt();
		        System.out.println(" DIGITE O SEGUNDO ");
		        x2 = teclado.nextInt();
		        System.out.println(" DIGITE O TERCEIRO ");
		        x3 = teclado.nextInt();
		        System.out.println(" DIGITE O QUARTO ");
		        x4 = teclado.nextInt();
		        
		        int soma = x1 + x2 + x3 + x4;
		        int subtracao = x1 - x2;
		        int produto = x1 * x2 * x3;
		        int media = soma / 4;
		        int formula = (x1 + x2) / (x3 - x4);
		        
		        System.out.println(" SOMA DE TODOS:" + soma);
		        System.out.println(" SUBTRA��O DO PRIMEIRO PELO SEGUNDO: " + subtracao);
		        System.out.println(" PRODUTO DOS TR�S PRIMEIROS: " + produto);
		        System.out.println(" M�DIA DOS VALORES: " + media);
		        System.out.println(" RESULTADO DA F�RMULA (1� valor + 2� valor) / (3� valor - 4� valor): " + formula);
	        		
	}

}
