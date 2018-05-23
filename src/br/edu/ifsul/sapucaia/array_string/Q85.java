package br.edu.ifsul.sapucaia.array_string;
import java.util.Scanner;
public class Q85 {
	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);
		short cont = 0;
		
		System.out.println("DIGITE UMA FRASE");
		String frase = t.nextLine();
		System.out.print("DIGITE UM CARACTERE: ");
		char c = t.next().charAt(0);
		
		for(short h = 0; h < frase.length(); h++) {
			if(frase.charAt(h) == c) {
				cont++;
			}
		}
		System.out.print("\nA frase tem "+cont+" letras "+c);
	}
}

// Ler uma frase, escolhe um caractere e mostra quantas vezes ele foi lido.