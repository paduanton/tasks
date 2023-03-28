package br.edu.ifsul.sapucaia.sequencial;
import java.util.Scanner;
public class Q31 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		double pista, voltas, litros, reabastecimento, consumo, conversao, conversao1;
		
		System.out.println("Qual o comprimento em metros da pista?");
		pista = teclado.nextDouble();
		System.out.println("Qual o n�mero de voltas a serem percorridas?");
		voltas = teclado.nextDouble();
		System.out.println("Qual o n�mero de reabastecimentos desejados?");
		reabastecimento = teclado.nextDouble();
		System.out.println("Digite o consumo de combust�vel do carro (em Km/l).");
		consumo = teclado.nextDouble();
		
		conversao1 = reabastecimento + 1;
		conversao = consumo * 1000;
		litros = ((pista * voltas)/conversao)/conversao1;
		
		System.out.println("A quantidade min�ma de litros para percorrer at� o primeiro abastecimento � " + litros);
		
	}
}
