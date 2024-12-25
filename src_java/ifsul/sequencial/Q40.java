package ifsul.sequencial;
import java.util.Scanner;
public class Q40 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		double produto, desconto, Nvalor;
		
		System.out.println("Qual o valor do produto?");
		produto = teclado.nextDouble();
		System.out.println("Insira a porcentagem do desconto.");
		desconto = teclado.nextDouble();
		
		Nvalor= produto-((desconto/100)*produto);
		
		System.out.println("O valor do produto com o desconto de " + desconto + "%" + " � de R$" +Nvalor);
		
	}
	
}