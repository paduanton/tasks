package br.edu.ifsul.sapucaia.decisao;
import java.util.Scanner;
public class Q62 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		double cotacao, conversao;
	    System.out.print("Deseja converter a quantia para qual moeda?\n\nDólar - D\nLibra esterlina - L\nEuro - E\n\nInsira a moeda: ");
	    String moeda = teclado.next();
	    System.out.print("Insira a quantia em reais a ser convertida: ");
	    double quantia = teclado.nextDouble();
	    
		if (moeda.equalsIgnoreCase("d")) {
			System.out.print("Qual a cotação do Dólar? ");
			cotacao = teclado.nextDouble();
			conversao = cotacao * quantia;
			System.out.print("\nMoeda: Dólar\nCotação: R$" + cotacao + "\nQuantia em Reais: R$" + quantia + "\nQuantia em Dólares: " + conversao);
		} else if (moeda.equalsIgnoreCase("l")) {
			System.out.print("Qual a cotação da Libra Esterlina? ");
			cotacao = teclado.nextDouble();
			conversao = cotacao * quantia;
			System.out.print("\nMoeda: Libra Esterlina\nCotação: R$" + cotacao + "\nQuantia em Reais: R$" + quantia + "\nQuantia em Libra Esterlina: " + conversao);
		} else if (moeda.equalsIgnoreCase("e")){
			System.out.print("Qual a cotação do Euro? ");
			cotacao = teclado.nextDouble();
			conversao = cotacao * quantia;
			System.out.print("\nMoeda: Euro\nCotação: R$" + cotacao + "\nQuantia em Reais: R$" + quantia + "\nQuantia em Euros: " + conversao);

		}
	}		
}