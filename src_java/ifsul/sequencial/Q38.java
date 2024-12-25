package br.edu.ifsul.sapucaia.sequencial;
import java.util.Scanner;
public class Q38 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Qual o p�blico total do jogo?");
		int total = teclado.nextInt();
		
		double popular = ((10/100)*total)*1, geral = ((50/100)*total)*5, arquibancada = ((30/100)*total)*10, cadeiras = ((10/100)*total)*20, renda = arquibancada+cadeiras+geral+popular;


		System.out.println("A renda total do jogo � de R$" + renda);
		
	}
	
}