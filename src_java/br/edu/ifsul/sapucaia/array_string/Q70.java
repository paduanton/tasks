package br.edu.ifsul.sapucaia.array_string;
import java.util.Scanner;
public class Q70 {
	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);
		
		System.out.print("Digite uma palavra: ");
		String palavra = t.next();
		System.out.print("Digite outra palavra: ");
		String palavra1 = t.next();
		
		int comp = palavra.compareToIgnoreCase(palavra1);
		palavra = palavra.concat(palavra1);
		System.out.println("\nConcatenada: "+palavra);
		
		if(comp == 0) {  // palavra.equalsIgnoreCase(palavra1)
			System.out.print("\nAs palavras s�o iguais");
		} else {
			System.out.print("\nAs palavras s�o diferentes");
			if(comp > 0) {
				System.out.print("\nA primeira palavra � maior");
			} else {
				System.out.print("\nA segunda palavra � maior");
			  }
		  }
	}
}
/*
Fa�a um programa que l� duas palavras e determina:
a) Se as duas palavras s�o iguais
b) Se s�o diferentes, qual delas � a maior (considerar que podem ser palavras diferentes de mesmo tamanho)
c) Mostra na tela as duas palavras concatenadas
*/