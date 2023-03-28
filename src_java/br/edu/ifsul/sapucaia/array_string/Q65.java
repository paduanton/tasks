package br.edu.ifsul.sapucaia.array_string;
import java.util.Scanner;
public class Q65 {
	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);
		byte h; String nome[] = new String[5];
		
		System.out.println("Digite 5 nomes");
		for(h = 0; h < 5; h++) {
			nome[h] = t.next();
		} 
		System.out.println("Primeira letra..."); 
		for(h = 0; h <= 4; h++) {
			System.out.println("Palavra "+(h+1)+": "+nome[h].charAt(0));
		 }
	}
}

// Elabore um algoritmo que leia 5 nomes e imprime o primeiro caractere de cada nome.