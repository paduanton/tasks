package br.edu.ifsul.sapucaia.sequencial;
import java.util.Scanner;
public class Q44 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		double apartamentos, desconto, valorD;
		
		System.out.println("Qual o n�mero de apartamentos do hotel?");
		apartamentos= teclado.nextDouble();
		System.out.println("Qual o valor da di�ria por apartamento?");
		valorD = teclado.nextDouble();
		System.out.println("Qual a porcentagem de desconto da di�ria?");
		desconto = teclado.nextDouble();
		
		double diaria = valorD-(desconto/100)*(valorD*1), valorT = (apartamentos*valorD)-((desconto/100)*(apartamentos*valorD)), valorT2 = ((0.7*apartamentos)*valorD)-((desconto/100)*((0.7*apartamentos)*valorD)), valornegativo = (apartamentos*valorD)-((desconto/100)*(apartamentos*valorD))+(desconto/100)*(apartamentos*valorD);
		
		System.out.println("A di�ria com desconto de " + desconto + "%" + " fica R$" + diaria + "\n" + "Valor total a ser arrecadado caso a ocupa��o total (100%): R$" + valorT + "\n" + "Valor total a ser arrecadado caso a ocupa��o seja de 70%: R$" + valorT2 + "\n" + "Valor que seria arrecadado sem o desconto: R$" + valornegativo);
		
	}

}
