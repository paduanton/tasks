package ifsul.array_string;
import java.util.Scanner;
public class Q10 {
	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);
		String nome[] = new String[5]; byte h;
		System.out.println("Informe 5 nomes");
		for(h = 0; h < 5; h++) {
			nome[h] = t.next();
		} for(h = 0; h <= 4; h++) {
			System.out.println("Nome "+(h+1)+": "+nome[h]);
		  }
	}
}
/*
 * Fa�a um programa que armazena 5 nomes em um vetor e mostra uma lista numerada com os
 * nomes.
*/