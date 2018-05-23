package br.edu.ifsul.sapucaia.array_string;
import java.util.Scanner;
public class Q72 {
	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);
		
		System.out.print("Digite uma palavra: ");
		String p = t.next();
		
		System.out.print("Quantidade de caracteres: "+p.length()+"\n");
		for(int h = 1; h <= p.length(); h++) {
			System.out.println(p);
		}
	}
}
/*
 * Fa�a um algoritmo que l� um nome e imprime-o tantas vezes quantos forem seus caracteres.
 */