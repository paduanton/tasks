package ifsul.sequencial;
import java.util.Scanner;
public class Q24 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		double produto, desconto, desconto1;
		
		System.out.println("Digite o valor de um produto");
		produto = teclado.nextDouble();
		
		 desconto1 = (produto * 9) / 100; desconto = produto - desconto1;
		
		System.out.println("O valor do produto � R$" + produto + " com desconto de 9% fica R$" + desconto + " e o desconto foi de R$" + desconto1);
	}

}
