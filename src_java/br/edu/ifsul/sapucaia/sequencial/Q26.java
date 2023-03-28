package br.edu.ifsul.sapucaia.sequencial;
import java.util.Scanner;
public class Q26 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		int dia, ano, mes;
		
		System.out.println(" Qual dia voc� nasceu? ");
		dia = teclado.nextInt();
		System.out.println(" Qual m�s voc� nasceu? ");
		mes = teclado.nextInt();
		System.out.println(" Voc� nasceu a quantos anos? ");
		ano = teclado.nextInt();
		
		
		int ano_dia = ano * 365, mes_dia = mes * 30, idade = ano_dia + mes_dia + dia;
		
		System.out.println(" Sua idade expressa em dias � " + idade);
		
		
	}
	
}