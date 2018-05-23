package br.edu.ifsul.sapucaia.sequencial;
import java.util.Scanner;
public class Q41 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		double valor, taxa, tempo, prestacao;
		
		System.out.println("Qual o valor da presta��o?");
		valor = teclado.nextDouble();
		System.out.println("Insira a porcentagem da taxa?");
		taxa = teclado.nextDouble();
		System.out.println("Qual o tempo de atraso?");
		tempo= teclado.nextDouble();
		
		prestacao = valor + (valor*(taxa/100)*tempo);
		
		System.out.println("O valor de uma presta��o em atraso" + prestacao);
		
	}
}
